package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate extends AbstractCoordinate implements Serializable {

    private double x;
    private double y;
    private double z;

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate() {
        this.x = 0.;
        this.y = 0.;
        this.z = 0.;
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        assert isDoubleInRange(x);
        assert isDoubleInRange(y);
        assert isDoubleInRange(z);

        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    /**
     * methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     * methodtype set
     */
    public void setX(double x) {
        assert isDoubleInRange(x);
        this.x = x;
        assertClassInvariants();
    }

    /**
     * methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     * methodtype set
     */
    public void setY(double y) {
        assert isDoubleInRange(y):
        this.y = y;
        assertClassInvariants();
    }

    /**
     * methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     * methodtype set
     */
    public void setZ(double z) {
        assert isDoubleInRange(z);
        this.z = z;
        assertClassInvariants();
    }

    @Override
    /**
     * @methodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }
}
