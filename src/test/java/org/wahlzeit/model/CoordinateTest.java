package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * All test cases of the class {@link Location}.
 */
public class CoordinateTest {
    private double epsilon = 0.000001;

    @Test
    public void testDefaultConstructor() {
        Coordinate c = new Coordinate();
        assertEquals(0., c.getLatitude(), epsilon);
        assertEquals(0., c.getLongitude(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalLatitude() {
        Coordinate c = new Coordinate(1000., 50.);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalLongitude() {
        Coordinate c = new Coordinate(50., 1000.);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetterIllegalLatitude() {
        Coordinate c = new Coordinate();
        c.setLatitude(1000.);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetterIllegalLongitude() {
        Coordinate c = new Coordinate();
        c.setLongitude(1000.);
    }

    @Test
    public void testDistanceBetweenSameCoordinate() {
        Coordinate c = new Coordinate(30., 30.);
        assertEquals(0., c.getDistance(c), epsilon);

        Coordinate c2 = new Coordinate(30., 30.);
        assertEquals(0., c.getDistance(c2), epsilon);
    }

    @Test
    public void testResultInDifferentOrder() {
        Coordinate c1 = new Coordinate(25., 25.);
        Coordinate c2 = new Coordinate(25., 25.);
        assertEquals(c1.getDistance(c2), c2.getDistance(c1), epsilon);
    }

    @Test
    public void testGetDistance() {
        Coordinate c1 = new Coordinate(55., 90.0);
        Coordinate c2 = new Coordinate(-35.0, 25.0);
        assertEquals(12746.795384, c1.getDistance(c2), epsilon);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDistanceNullPointer() {
        Coordinate c = new Coordinate(10., 10.);
        c.getDistance(null);
    }
}
