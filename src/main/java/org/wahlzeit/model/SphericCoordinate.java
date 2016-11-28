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
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double lat, double lon, double radius) {
        assert isDoubleInRange(lat);
        assert isDoubleInRange(lon);
        assert isDoubleInRange(radius);
        assert isValidRadius(radius);

        this.latitude = lat;
        this.longitude = lon;
        this.radius = radius;

        assertClassInvariants();
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
        assert isDoubleInRange(lat);
        this.latitude = lat;
        assertClassInvariants();
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
        assert isDoubleInRange(lon);
        this.longitude = lon;
        assertClassInvariants();
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
        assert isDoubleInRange(radius);
        assert isValidRadius(radius);
        this.radius = radius;
        assertClassInvariants();
    }

    @Override
    /**
     * @mathodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        CartesianCoordinate result = new CartesianCoordinate(getCartesianX(), getCartesianY(), getCartesianZ());

        assert this.isEqual(result);
        assertClassInvariants();
        assert isValidCoordinate(result);

        return result;
    }

    /**
     * @methodtype get
     */
    private double getCartesianX() {
        double result = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
        assertClassInvariants();
        return result;
    }

    /**
     * @methodtype get
     */
    private double getCartesianY() {
        double result = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
        assertClassInvariants();
        return result;
    }

    /**
     * @methodtype get
     */
    private double getCartesianZ() {
        double result = radius * Math.cos(Math.toRadians(longitude));
        assertClassInvariants();
        return result;
    }

    /**
     * @methodtype assertion
     */
    protected void assertClassInvariants() {
        super.assertClassInvariants();
        assert isDoubleInRange(latitude);
        assert isDoubleInRange(longitude);
        assert isDoubleInRange(radius);
        assert isValidRadius(radius);
    }

    /**
     * @methodtype assertion
     */
    protected boolean isValidRadius(double radius) {
        return radius >= 0;
    }
}
