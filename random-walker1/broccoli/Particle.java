package broccoli;

import java.util.List;

/**
 *
 * @author Vinh
 */
public class Particle
{
    
    private Location location;
    
    private int x;
    private int y;
    private int z;
    
    private final Grid grid;
    
    /**
     * 
     * @param grid
     * @param location 
     */
    public Particle(Grid grid, Location location)
    {
        this.grid = grid;
        setLocation(location);
    }
    
    /**
     * 
     */
    public void act()
    {
        System.out.println("Particle b4 location: " + Integer.toString(x)
                + " " + Integer.toString(y) + " " + Integer.toString(z));
        List<Location> adjLocations = grid.getAdjacentLocations(location);
        randomWalk(adjLocations);
        System.out.println("Particle after location: " + Integer.toString(x)
                + " " + Integer.toString(y) + " " + Integer.toString(z));
    }
    
    private void randomWalk(List<Location> locations)
    {
        int availableSize = locations.size();
        double randomIndex = Math.random() * availableSize;
        randomIndex = Math.floor(randomIndex);
        int randIndex = (int)randomIndex; //Integer.parseInt(Double.toString(randomIndex));
        
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
    
    /**
     * 
     * @param loc 
     */
    private void setLocation(Location loc)
    {
        location = loc;
        grid.place(this, loc);
        x = location.getX();
        y = location.getY();
        z = location.getZ();
    }
}
