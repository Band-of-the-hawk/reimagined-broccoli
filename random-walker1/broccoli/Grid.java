package broccoli;

import java.util.*;

/**
 * Represent a grid of field positions.
 * Each position is able to store a single object.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Grid
{
    
    // Constants defining which dimensions to use
    private final static int ONE_D = 1;
    private final static int TWO_D = 2;
    private final static int THREE_D = 3;
    
    // Current dimension
    private final int dim;
    
    // The depth and width of the field.
    private final int x, y, z;

    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     */
    public Grid(int x)
    {
        this.dim = 1;
        this.x = 2*x;
        this.y = 0;
        this.z = 0;
    }
    
    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param y The width of the field.
     */
    public Grid(int x, int y)
    {
        this.dim = 2;
        this.x = 2*x;
        this.y = 2*y;
        this.z = 0;
    }
    
    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param y The width of the field.
     * @param z
     */
    public Grid(int x, int y, int z)
    {
        this.dim = 3;
        this.x = 2*x;
        this.y = 2*y;
        this.z = 2*z;
    }
    
    /**
     * 
     * @return 
     */
    public Location getCenterLocation()
    {
        return new Location(x/2,y/2,z/2);
    }
    
    /**
     *
     * @param location the value of location
     * @return 
     */
    public List<Location> getAdjacentLocations(Location location)
    {
        List<Location> adjLocations = new LinkedList<>();
        int xLoc = location.getX();
        int yLoc = location.getY();
        int zLoc = location.getZ();
        
        switch (dim) {
            case ONE_D:
                adjLocations.add(new Location(xLoc - 1));
                adjLocations.add(new Location(xLoc + 1));
                break;
            case TWO_D:
                adjLocations.add(new Location(xLoc - 1, yLoc));
                adjLocations.add(new Location(xLoc + 1, yLoc));
                adjLocations.add(new Location(xLoc, yLoc - 1));
                adjLocations.add(new Location(xLoc, yLoc + 1));
                break;
            case THREE_D:
                adjLocations.add(new Location(xLoc - 1, yLoc, zLoc));
                adjLocations.add(new Location(xLoc + 1, yLoc, zLoc));
                adjLocations.add(new Location(xLoc, yLoc - 1, zLoc));
                adjLocations.add(new Location(xLoc, yLoc + 1, zLoc));
                adjLocations.add(new Location(xLoc, yLoc, zLoc - 1));
                adjLocations.add(new Location(xLoc, yLoc, zLoc + 1));
                break;
            default:
                break;
        }
        return adjLocations;
    }

    /**
     * Return the depth of the field.
     * @return The depth of the field.
     */
    public int getDepth()
    {
        return x;
    }
    
    /**
     * Return the width of the field.
     * @return The width of the field.
     */
    public int getWidth()
    {
        return y;
    }
    
    /**
     * Return the height of the field.
     * @return The height of the field.
     */
    public int getHeight()
    {
        return z;
    }
}
