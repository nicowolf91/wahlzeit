package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {

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
