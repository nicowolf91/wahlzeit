package org.wahlzeit.model;

/*
 * Coordinate
 *
 * version 1
 *
 * date 24.10.2016
*/
public class Coordinate {

    public static final double EARTH_RADIUS = 6371;

    private double latitude;
    private double longitude;

    public Coordinate() {
        this.latitude = 0.;
        this.longitude = 0.;
    }

    public Coordinate(double lat, double lon) {
        checkLatLon(lat, lon);
        this.latitude = lat;
        this.longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double lat) {
        checkLat(lat);
        this.latitude = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double lon) {
        checkLon(lon);
        this.longitude = lon;
    }

    public double getDistance(Coordinate cd) {
        double otherLat = cd.getLatitude();
        double otherLon = cd.getLongitude();
        double lambda = Math.abs(otherLon - longitude);
        double sigma = Math.acos(Math.sin(latitude) * Math.sin(otherLat) + Math.cos(latitude) * Math.cos(otherLat) * Math.cos(lambda));
        return sigma * EARTH_RADIUS;
    }

    private void checkLat(double lat) {
        if(lat < -90 || lat > 90) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLon(double lon) {
        if(lon < -180 || lon > 180) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLatLon(double lat, double lon) {
        checkLat(lat);
        checkLon(lon);
    }
}
