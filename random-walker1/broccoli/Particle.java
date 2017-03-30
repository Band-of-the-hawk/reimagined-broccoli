package broccoli;

/**
 *
 * @author Vinh
 */
<<<<<<< HEAD
public class Particle {
=======
public abstract class Particle {
    
    private boolean inAction;
    
    private Location location;
    
    private Grid grid;
    
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
>>>>>>> 9c68eaf7a066acd79633e4e31b90c6a95434e4e9
    
}
