package broccoli;

import java.util.List;

/**
 *
 * @author Vinh
 */
public class Particle
{
    
    private Location location;
    
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
        List<Location> adjLocations = grid.getAdjacentLocations(location);
        randomWalk(adjLocations);
    }
    
    private void randomWalk(List<Location> locations)
    {
        int availableSize = locations.size();
        double randomIndex = Math.random() * availableSize;
        randomIndex = Math.floor(randomIndex);
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
     * @param center 
     */
    private void setLocation(Location center)
    {
        
        location = center;
        grid.place(this, center);
    }
}
