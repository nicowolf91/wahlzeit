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
    }

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
        this.x = x;
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
        this.y = y;
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
        this.z = z;
    }

    @Override
    /**
     * @methodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }
}
