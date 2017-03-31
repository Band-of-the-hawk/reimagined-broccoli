package broccoli;

import java.util.List;

/**
 *
 * @author Vinh
 */
public class Particle {
    
    //private final boolean inAction;
    
    private Location location;
    
    private final Grid grid;
    
    
    public Particle(Grid grid, Location location)
    {
        //this.inAction = true;
        this.grid = grid;
        setLocation(location);
    }
    
    public void act(List<Particle> newParticle)
    {
        
        System.out.println("sup");
    }
    
    /*public boolean isInAction()
    {
        return inAction;
    }*/
    
    private Grid getGrid()
    {
        return grid;
    }
    
    private Location getLoaction()
    {
        return location;
    }
    
    private void setLocation(Location center)
    {
        
        location = center;
        grid.place(this, center);
    }
    
    
}
