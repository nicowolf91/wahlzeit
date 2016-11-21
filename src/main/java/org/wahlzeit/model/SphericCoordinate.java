package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate extends AbstractCoordinate implements Serializable {

    private double latitude;
    private double longitude;
    private double radius;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate() {
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = 0.;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double lat, double lon, double radius) {
        this.latitude = lat;
        this.longitude = lon;
        this.radius = radius;
    }

    /**
     * @methodtype get
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype set
     */
    public void setLatitude(double lat) {
        this.latitude = lat;
    }

    /**
     * @methodtype get
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype set
     */
    public void setLongitude(double lon) {
        this.longitude = lon;
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    /**
     * @mathodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        return new CartesianCoordinate(getCartesianX(), getCartesianY(), getCartesianZ());
    }

    /**
     * @methodtype get
     */
    private double getCartesianX() {
        return radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
    }

    /**
     * @methodtype get
     */
    private double getCartesianY() {
        return radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
    }

    /**
     * @methodtype get
     */
    private double getCartesianZ() {
        return radius * Math.cos(Math.toRadians(longitude));
    }
}
