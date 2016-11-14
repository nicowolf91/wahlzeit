package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    private static final double epsilon = 10e-6;

    private CartesianCoordinate cc;
    private SphericCoordinate sc;

    @Before
    public void setUp() {
        cc = new CartesianCoordinate(1111., 2222., 3333.);
        sc = new SphericCoordinate(45., 30.);
    }

    @Test
    public void getDistance() {
        assertEquals(2464.90127, cc.getDistance(sc), epsilon);
    }
}
