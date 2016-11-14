package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {
    private static final double epsilon = 10e-6;

    private SphericCoordinate def;
    private SphericCoordinate c1;
    private SphericCoordinate c2;
    private SphericCoordinate c3;

    @Before
    public void setUp() {
        def = new SphericCoordinate();
        c1 = new SphericCoordinate(60.0, 30.0);
        c2 = new SphericCoordinate(90.0, 90.0);
        c3 = new SphericCoordinate(-50.0, 70.0);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, def.getLatitude(), epsilon);
        assertEquals(0.0, def.getLongitude(), epsilon);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, def.getRadius(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLatitude() {
        SphericCoordinate c = new SphericCoordinate(200., 55., SphericCoordinate.EARTH_RADIUS_KM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLongitude() {
        SphericCoordinate c = new SphericCoordinate(55., 200., SphericCoordinate.EARTH_RADIUS_KM);
    }

    @Test
    public void testGetX() {
        assertEquals(1592.75, c1.getX(), epsilon);
    }

    @Test
    public void testGetY() {
        assertEquals(2758.723924, c1.getY(), epsilon);
    }

    @Test
    public void testGetZ() {
        assertEquals(5517.447848, c1.getZ(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceNullArgument() {
        c1.getDistance(null);
    }

    @Test
    public void testGetDistanceSameCoordinate() {
        assertEquals(0.0, c2.getDistance(c2), epsilon);
    }

    @Test
    public void testGetDistance() {
        assertEquals(11815.916749, c2.getDistance(c3), epsilon);
    }
}
