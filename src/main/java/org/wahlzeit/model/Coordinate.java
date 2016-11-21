package org.wahlzeit.model;

public interface Coordinate {
    /**
     * @methodtype get
     */
    double getDistance(Coordinate c);

    /**
     * @methodtype conversion
     */
    CartesianCoordinate asCartesianCoordinate();

    /**
     * @mathodtype comparison
     */
    boolean isEqual(Coordinate c);
}
