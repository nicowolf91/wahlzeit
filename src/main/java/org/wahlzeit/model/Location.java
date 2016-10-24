package org.wahlzeit.model;

/*
 * Location
 *
 * version 1
 *
 * date 24.10.2016
*/
public class Location {

    public Coordinate coordinate;

    public Location() {

    }

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
