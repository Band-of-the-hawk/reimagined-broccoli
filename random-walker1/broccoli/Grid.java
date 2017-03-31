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
    // Storage for the animals.
    private final Object[][][] grid;

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
        grid = new Object[2*x][0][0];
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
        grid = new Object[2*x][2*y][0];
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
        grid = new Object[2*x][2*y][2*z];
    }
    
    /**
     * Empty the field.
     */
    public void clearAll()
    {
        for(int xPos = 0; xPos < this.x; xPos++) {
            for(int yPos = 0; yPos < this.y; yPos++) {
                for(int zPos = 0; zPos < this.z; zPos++) {
                    grid[xPos][yPos][zPos] = null;
                }
            }
        }
    }
    
    /**
     * Clear the given location.
     * @param location The location to clearAll.
     */
    public void clear(Location location)
    {
        grid[location.getX()][location.getY()][location.getZ()] = null;
    }
    
    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param particle The particle to be placed.
     * @param x Row coordinate of the location.
     * @param y Column coordinate of the location.
     * @param z Height coordinate of the location.
     */
    public void place(Object particle, int x, int y, int z)
    {
        place(particle, new Location(x, y, z));
    }
    
    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param particle The animal to be placed.
     * @param location Where to place the animal.
     */
    public void place(Object particle, Location location)
    {
        grid[location.getX()][location.getY()][location.getZ()] = particle;
    }
    
    /**
     * Return the animal at the given location, if any.
     * @param location Where in the field.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(Location location)
    {
        return getObjectAt(location.getX(), location.getY(), location.getZ());
    }
    
    /**
     * 
     * @param x
     * @return 
     */
    public Object getObjectAtOne(int x)
    {
        return grid[x][0][0];
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public Object getObjectAtTwo(int x, int y)
    {
        return grid[x][y][0];
    }
    
    /**
     * Return the animal at the given location, if any.
     * @param x The desired row.
     * @param y The desired column.
     * @param z The desired height level
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(int x, int y, int z)
    {
        return grid[x][y][z];
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
