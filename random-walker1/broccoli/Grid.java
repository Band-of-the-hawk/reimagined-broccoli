package broccoli;

import java.util.*;

/**
 * Represent a grid of field positions.
 * Each position is able to store a single object.
 * 
 * @author Vinh Tran, Thomas Todal, Kristoffer Martinsen
 * @version 31.03.2017
 */
public class Grid
{
    
    // Constants defining which dimensions to use
    private final static int ONE_D = 1;
    private final static int TWO_D = 2;
    private final static int THREE_D = 3;
    
    // Current dimension
    private final int dim;
    
    // The depth, width and height of the field.
    private final int x, y, z;
    
    private final GridBorder gB;
    
    private final LogInfo logI;

    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param logI
     */
    public Grid(int x, LogInfo logI)
    {
        this(x, 0, 0, ONE_D, logI);
    }
    
    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param y The width of the field.
     * @param logI
     */
    public Grid(int x, int y, LogInfo logI)
    {
        this(x, y, 0, TWO_D, logI);
    }
    
    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param y The width of the field.
     * @param z The height of the field.
     * @param logI
     */
    public Grid(int x, int y, int z, LogInfo logI)
    {
        this(x, y, z, THREE_D, logI);
    }
    
    /**
     * Represent a field of the given dimensions.
     * @param x The depth of the field.
     * @param y The width of the field.
     * @param z The height of the field.
     * @param dim The dimension of the grid.
     * @param logI
     */
    public Grid(int x, int y, int z, int dim, LogInfo logI)
    {
        this.dim = dim;
        
        this.x = x/2;
        this.y = y/2;
        this.z = z/2;
        
        this.gB = new GridBorder(logI);
        
        this.logI = logI;
    }
    
    /**
     * 
     * @return the center location
     */
    public Location getCenterLocation()
    {
        return new Location(0,0,0);
    }
    
    /**
     * This function keeps control of which dimension it should simulate
     * 1D, 2D or 3D
     * @param location the value of location
     * @return return the AdjacentLocation
     */
    public List<Location> getAdjacentLocations(Location location)
    {
        List<Location> adjLocations = new LinkedList<>();
        int xLoc = location.getX();
        int xLocPlus = gB.checkBorder(location.getX() + 1, x);
        int xLocMinus = gB.checkBorder(location.getX() - 1, x);
        int yLoc = location.getY();
        int yLocPlus = gB.checkBorder(location.getY() + 1, y);
        int yLocMinus = gB.checkBorder(location.getY() - 1, y);
        int zLoc = location.getZ();
        int zLocPlus = gB.checkBorder(location.getZ() + 1, z);
        int zLocMinus = gB.checkBorder(location.getZ() - 1, z);
        
        
        
        switch (dim) {
            case ONE_D:
                adjLocations.add(new Location(xLocPlus));
                adjLocations.add(new Location(xLocMinus));
                break;
            case TWO_D:
                adjLocations.add(new Location(xLocPlus, yLoc));
                adjLocations.add(new Location(xLocMinus, yLoc));
                adjLocations.add(new Location(xLoc, yLocPlus));
                adjLocations.add(new Location(xLoc, yLocMinus));
                break;
            case THREE_D:
                adjLocations.add(new Location(xLocPlus, yLoc, zLoc));
                adjLocations.add(new Location(xLocMinus, yLoc, zLoc));
                adjLocations.add(new Location(xLoc, yLocPlus, zLoc));
                adjLocations.add(new Location(xLoc, yLocMinus, zLoc));
                adjLocations.add(new Location(xLoc, yLoc, zLocPlus));
                adjLocations.add(new Location(xLoc, yLoc, zLocMinus));
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
    public int getXMax()
    {
        return x;
    }
    
    /**
     * Return the width of the field.
     * @return The width of the field.
     */
    public int getYMax()
    {
        return y;
    }
    
    /**
     * Return the height of the field.
     * @return The height of the field.
     */
    public int getZMax()
    {
        return z;
    }
}
