package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SphericCoordinateTest {
    private static final double epsilon = 10e-6;

    private SphericCoordinate def;
    private SphericCoordinate c1;
    private SphericCoordinate c2;
    private SphericCoordinate c3;

    @Before
    public void setUp() {
        def = SphericCoordinate.getInstance(0., 0., 0.);
        c1 = SphericCoordinate.getInstance(60.0, 30.0, 6371.);
        c2 = SphericCoordinate.getInstance(90.0, 90.0, 6371.);
        c3 = SphericCoordinate.getInstance(-50.0, 70.0, 6371.);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, def.getLatitude(), epsilon);
        assertEquals(0.0, def.getLongitude(), epsilon);
        assertEquals(0.0, def.getRadius(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceNullArgument() {
        c1.getDistance(null);
    }

    @Test
    public void testGetDistanceSameCoordinate() {
        assertEquals(0.0, c2.getDistance(c2), epsilon);
        assertTrue(c2.isEqual(c2));
    }

    @Test
    public void testGetDistance() {
        assertEquals(11815.916749, c2.getDistance(c3), epsilon);
    }

    @Test
    public void testAsCartesianCoordinate() {
        assertEquals(1592.75, c1.asCartesianCoordinate().getX(), epsilon);
        assertEquals(2758.723924, c1.asCartesianCoordinate().getY(), epsilon);
        assertEquals(5517.447848, c1.asCartesianCoordinate().getZ(), epsilon);
    }
}
