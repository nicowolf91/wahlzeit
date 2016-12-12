package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate extends AbstractCoordinate implements Serializable {

    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * @methodtype constructor
     */
    private SphericCoordinate() {
        this(0., 0., 0.);
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    private SphericCoordinate(double lat, double lon, double radius) {
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
     * @methodtype factory method
     */
    public static SphericCoordinate getInstance(final double lat, final double lon, final double radius) {
        SphericCoordinate sc = new SphericCoordinate(lat, lon, radius);
        int hash = sc.hashCode();
        Coordinate c = instances.get(hash);

        if(c == null) {
            instances.put(hash, sc);
            c = sc;
        }

        return (SphericCoordinate) c;
    }


    /**
     * @methodtype get
     */
    public double getLatitude() {
        return latitude;
    }


    /**
     * @methodtype get
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    @Override
    /**
     * @mathodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        CartesianCoordinate result = CartesianCoordinate.getInstance(getCartesianX(), getCartesianY(), getCartesianZ());

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
