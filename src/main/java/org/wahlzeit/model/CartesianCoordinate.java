package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate extends AbstractCoordinate implements Serializable {

    private final double x;
    private final double y;
    private final double z;

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate() {
        this(0., 0., 0.);
        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     */
    private CartesianCoordinate(double x, double y, double z) {
        assertDoubleIsInRange(x);
        assertDoubleIsInRange(y);
        assertDoubleIsInRange(z);

        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    /**
     * @methodtype factory method
     */
    public static CartesianCoordinate getInstance(final double x, final double y, final double z) {
        CartesianCoordinate cc = new CartesianCoordinate(x, y, z);
        int hash = cc.hashCode();
        Coordinate c = instances.get(hash);

        if(c == null) {
            instances.put(hash, cc);
            c = cc;
        }

        return (CartesianCoordinate) c;
    }

    /**
     * methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     * methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     * methodtype get
     */
    public double getZ() {
        return z;
    }

    @Override
    /**
     * @methodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }
}
