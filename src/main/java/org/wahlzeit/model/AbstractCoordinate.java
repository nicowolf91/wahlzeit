package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    @Override
    /**
     * @methodtype get
     */
    public double getDistance(Coordinate c) {
        //the post- and preconditions are tested by the other getDistance-method
        return this.getDistance(c.asCartesianCoordinate());
    }

    @Override
    /**
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate c) {
        assertIsNonNullCoordinate(c);
        assertIsValidCoordinate(c);

        boolean result = this.getDistance(c) == 0;

        assertClassInvariants();
        assertIsValidCoordinate(c);

        return result;
    }

    /**
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate cc) {
        assertIsNonNullCoordinate(cc);
        assertIsValidCoordinate(cc);

        double result = Math.sqrt(
                Math.pow(cc.getX() - asCartesianCoordinate().getX(), 2) +
                Math.pow(cc.getY() - asCartesianCoordinate().getY(), 2) +
                Math.pow(cc.getZ() - asCartesianCoordinate().getZ(), 2)
        );

        assertDoubleIsInRange(result);
        assert result >= 0;
        assertClassInvariants();
        assertIsValidCoordinate(cc);

        return result;
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNonNullCoordinate(Coordinate c) {
        if(c == null) {
            throw new IllegalArgumentException("Coordinate must not be null!");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertDoubleIsInRange(double d) {
        if(Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("value [" + d + "] is not valid");
        }
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assertIsValidCoordinate(this);
    }

    /**
     * @methodtype
     */
    protected void assertIsValidCoordinate(Coordinate c) {
        CartesianCoordinate cc = c.asCartesianCoordinate();
        assertDoubleIsInRange(cc.getX());
        assertDoubleIsInRange(cc.getY());
        assertDoubleIsInRange(cc.getZ());
    }
}
