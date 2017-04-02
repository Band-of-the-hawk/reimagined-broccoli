package broccoli;

import java.util.List;

/**
 * Represent the particle list
 * 
 * @author Vinh Tran, Thomas Todal, Kristoffer Martinsen
 * @version 31.03.2017
 */
public class Particle
{
    
    private Location location;
    
    private int x;
    private int y;
    private int z;
    
    private final Grid grid;
    
    private final int number;
    
    /**
     * 
     * @param grid
     * @param location 
     * @param number the value of number 
     */
    public Particle(Grid grid, Location location, int number)
    {
        this.grid = grid;
        setLocation(location);
        this.number = number;
    }
    
    /**
     * An act function which make control where the function moves.
     * 
     */
    public void act()
    {
        System.out.println("Particle b4 location: " + Integer.toString(x)
                + " " + Integer.toString(y) + " " + Integer.toString(z)); //DEBUGGING
        
        List<Location> adjLocations = grid.getAdjacentLocations(location);
        randomWalk(adjLocations);
        
        System.out.println("Particle after location: " + Integer.toString(x)
                + " " + Integer.toString(y) + " " + Integer.toString(z)); //DEBUGGING
    }
    
    /**
     * Represent the random walk of a particle.
     * @param locations 
     */
    private void randomWalk(List<Location> locations)
    {
        int availableSize = locations.size();
        double randomIndex = Math.random() * availableSize;
        randomIndex = Math.floor(randomIndex);
        int randIndex = (int)randomIndex;
        
        setLocation(locations.get(randIndex));
    }
    
    /**
     * 
     * @return 
     */
    private Grid getGrid()
    {
        return grid;
    }
    
    /**
     * 
     * @return 
     */
    private Location getLoaction()
    {
        return location;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Set the location of the particle
     * @param loc 
     */
    private void setLocation(Location loc)
    {
        location = loc;
        //grid.place(this, loc);
        x = location.getX();
        y = location.getY();
        z = location.getZ();
    }
}
