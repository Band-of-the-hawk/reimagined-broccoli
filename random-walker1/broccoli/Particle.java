package broccoli;

import java.util.List;

/**
 *
 * @author Vinh
 */
public abstract class Particle {
    
    private final boolean inAction;
    
    private Location location;
    
    private final Grid grid;
    
    // act
    public abstract void act(List<Particle> newParticle);
    
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
}
