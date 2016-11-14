package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate implements Serializable, Coordinate {

    public static final double EARTH_RADIUS_KM = 6371.;

    private double latitude;
    private double longitude;
    private double radius;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate() {
        this.latitude = 0.;
        this.longitude = 0.;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double lat, double lon) {
        checkLatLon(lat, lon);
        this.latitude = lat;
        this.longitude = lon;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double lat, double lon, double radius) {
        checkLatLon(lat, lon);
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
        checkLat(lat);
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
        checkLon(lon);
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
     * @methodtype get
     */
    public double getX() {
        return radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
    }

    @Override
    /**
     * @methodtype get
     */
    public double getY() {
        return radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
    }

    @Override
    /**
     * @methodtype get
     */
    public double getZ() {
        return radius * Math.cos(Math.toRadians(longitude));
    }

    @Override
    /**
     * @methodtype get
     */
    public double getDistance(Coordinate c) {
        if (c == null) {
            throw new IllegalArgumentException("other Coordinate mustn't be null");
        }

        return Math.sqrt(Math.pow(c.getX() - getX(), 2) + Math.pow(c.getY() - getY(), 2) + Math.pow(c.getZ() - getZ(), 2));
    }

    /**
     * @methodtype assertion
     */
    private void checkLat(double lat) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @methodtype assertion
     */
    private void checkLon(double lon) {
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @methodtype assertion
     */
    private void checkLatLon(double lat, double lon) {
        checkLat(lat);
        checkLon(lon);
    }
}
