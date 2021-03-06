package org.wahlzeit.model;

import java.util.concurrent.ConcurrentHashMap;

@PatternInstance(
        patternName = "Template Method",
        participants = {"Abstract Class"}
)
public abstract class AbstractCoordinate implements Coordinate {

    protected static ConcurrentHashMap<Integer, Coordinate> instances = new ConcurrentHashMap<>();

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
        assertSubclassInvariants();
    }

    /**
     * @methodtype assertion
     */
    abstract void assertSubclassInvariants();

    /**
     * @methodtype assertion
     */
    protected void assertIsValidCoordinate(Coordinate c) {
        CartesianCoordinate cc = c.asCartesianCoordinate();
        assertDoubleIsInRange(cc.getX());
        assertDoubleIsInRange(cc.getY());
        assertDoubleIsInRange(cc.getZ());
    }

    @Override
    /**
     * @methodtype comparison
     */
    public int hashCode() {
        int result;
        long temp;
        CartesianCoordinate cc = asCartesianCoordinate();
        temp = Double.doubleToLongBits(cc.getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cc.getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cc.getZ());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    /**
     * @methodtype comparison
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartesianCoordinate me = this.asCartesianCoordinate();
        CartesianCoordinate that = (CartesianCoordinate) o;

        if (Double.compare(me.getX(), that.getX()) != 0) return false;
        if (Double.compare(me.getY(), that.getY()) != 0) return false;
        return Double.compare(me.getZ(), that.getZ()) == 0;
    }
}
