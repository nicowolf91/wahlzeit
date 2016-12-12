package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {
    private static final double epsilon = 10e-6;

    private CartesianCoordinate cc;
    private SphericCoordinate sc;

    private CartesianCoordinate cc2;
    private SphericCoordinate sc2;

    @Before
    public void setUp() {
        cc = CartesianCoordinate.getInstance(1111., 2222., 3333.);
        sc = SphericCoordinate.getInstance(45., 30., 6371.);

        cc2 = CartesianCoordinate.getInstance(0., 0., 0.);
        sc2 = SphericCoordinate.getInstance(0., 0., 0.);
    }

    @Test
    public void testGetDistance() {
        assertEquals(2464.90127, cc.getDistance(sc), epsilon);
    }

    @Test
    public void testIsEqual() {
        assertTrue(cc2.isEqual(sc2));
    }
}
