package broccoli;

import java.util.List;

/**
 *
 * @author Vinh
 */
public class Particle {
    
    private final boolean inAction;
    
    private Location location;
    
    private final Grid grid;
    
    // act
    public void act(List<Particle> newParticle)
    {
        System.out.println("sup");
    }
    
    protected Particle(Grid grid, Location location)
    {
        this.inAction = true;
        this.grid = grid;
        setLocation(location);
    }
    
    protected boolean isInAction()
    {
        return inAction;
    }
    
    protected Grid getGrid()
    {
        return grid;
    }
    
    protected Location getLoaction()
    {
        return location;
    }
    
    protected void setLocation(Location center)
    {
        if(location != null)
        {
            //Add particle
        }
        location = center;
        grid.place(this, center);
    }
    
    private void addParticle(List<Particle> newParticle)
    {
        Grid grid = getGrid();
        
    }
}
