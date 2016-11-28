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
        assert isNonNullCoordinate(c);
        assert isValidCoordinate(c);

        boolean result = this.getDistance(c) == 0;

        assertClassInvariants();
        assert isValidCoordinate(c);

        return result;
    }

    /**
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate cc) {
        assert isNonNullCoordinate(cc);
        assert isValidCoordinate(cc);

        double result = Math.sqrt(
                Math.pow(cc.getX() - asCartesianCoordinate().getX(), 2) +
                Math.pow(cc.getY() - asCartesianCoordinate().getY(), 2) +
                Math.pow(cc.getZ() - asCartesianCoordinate().getZ(), 2)
        );

        assert isDoubleInRange(result);
        assert result >= 0;
        assertClassInvariants();
        isValidCoordinate(cc);

        return result;
    }

    /**
     * @methodtype assertion
     */
    protected boolean isNonNullCoordinate(Coordinate c) {
        if(c == null) {
            return false;
        }
        return true;
    }

    /**
     * @methodtype assertion
     */
    protected boolean isDoubleInRange(double d) {
        if(!(Double.isInfinite(d) || Double.isNaN(d))) {
            return true;
        }
        return false;
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        assert isValidCoordinate(this);
    }

    /**
     * @methodtype
     */
    protected boolean isValidCoordinate(Coordinate c) {
        CartesianCoordinate cc = c.asCartesianCoordinate();
        return isDoubleInRange(cc.getX()) && isDoubleInRange(cc.getY()) && isDoubleInRange(cc.getZ());
    }
}
