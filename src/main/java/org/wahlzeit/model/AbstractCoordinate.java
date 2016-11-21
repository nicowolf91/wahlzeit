package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    @Override
    /**
     * @methodtype get
     */
    public double getDistance(Coordinate c) {
        assertNonNullCoordinate(c);
        return this.getDistance(c.asCartesianCoordinate());
    }

    @Override
    /**
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate c) {
        return this.getDistance(c) == 0;
    }

    /**
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate cc) {
        assertNonNullCoordinate(cc);
        return Math.sqrt(
                Math.pow(cc.getX() - asCartesianCoordinate().getX(), 2) +
                Math.pow(cc.getY() - asCartesianCoordinate().getY(), 2) +
                Math.pow(cc.getZ() - asCartesianCoordinate().getZ(), 2)
        );
    }

    /**
     * @methodtype assertion
     */
    protected void assertNonNullCoordinate(Coordinate c) {
        if(c == null) {
            throw new IllegalArgumentException();
        }
    }
}
