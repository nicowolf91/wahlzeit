package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartesianCoordinateTest {
    private static final double epsilon = 10e-6;

    private CartesianCoordinate def;
    private CartesianCoordinate c1;
    private CartesianCoordinate c2;
    private CartesianCoordinate c3;

    @Before
    public void setUp() {
        def = new CartesianCoordinate();
        c1 = new CartesianCoordinate(5., 6., 7.);
        c2 = new CartesianCoordinate(44., 13., 27.);
        c3 = new CartesianCoordinate(11., 10., 12.);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0.0, def.getX(), epsilon);
        assertEquals(0.0, def.getY(), epsilon);
        assertEquals(0.0, def.getZ(), epsilon);
    }

    @Test
    public void testSameCoordinate() {
        assertEquals(0.0, c1.getDistance(c1), epsilon);
        assertTrue(c1.isEqual(c1));
    }

    @Test
    public void testGetX() {
        assertEquals(44., c2.getX(), epsilon);
    }

    @Test
    public void testGetY() {
        assertEquals(13., c2.getY(), epsilon);
    }

    @Test
    public void testGetZ() {
        assertEquals(27., c2.getZ(), epsilon);
    }

    @Test
    public void getDistance() {
        assertEquals(8.77496, c1.getDistance(c3), epsilon);
    }
}
