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
        this(0., 0., 0);
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double lat, double lon, double radius) {
        assertDoubleIsInRange(lat);
        assertDoubleIsInRange(lon);
        assertDoubleIsInRange(radius);
        assertIsValidRadius(radius);

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
        assertDoubleIsInRange(lat);
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
        assertDoubleIsInRange(lon);
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
        assertDoubleIsInRange(radius);
        assertIsValidRadius(radius);
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
        assertIsValidCoordinate(result);

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
        assertDoubleIsInRange(latitude);
        assertDoubleIsInRange(longitude);
        assertDoubleIsInRange(radius);
        assertIsValidRadius(radius);
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsValidRadius(double radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("radius must not be negative!");
        }
    }
}
