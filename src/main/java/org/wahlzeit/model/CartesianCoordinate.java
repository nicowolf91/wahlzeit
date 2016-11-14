package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate implements Serializable, Coordinate {

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

    @Override
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

    @Override
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

    @Override
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
     * methodtype get
     */
    public double getDistance(Coordinate c) {
        if (c == null) {
            throw new IllegalArgumentException("other Coordinate mustn't be null");
        }

        return Math.sqrt(Math.pow(c.getX() - getX(), 2) + Math.pow(c.getY() - getY(), 2) + Math.pow(c.getZ() - getZ(), 2));
    }
}
