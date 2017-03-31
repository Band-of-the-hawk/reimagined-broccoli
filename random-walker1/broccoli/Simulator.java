package broccoli;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_X = 10;
    // The default depth of the grid.
    private static final int DEFAULT_Y = 10;
    // The default height of the grid.
    private static final int DEFAULT_Z = 10;
    
    

     //TODO
    // Lists of animals in the field.
    private List<Particle> particles;
    // The current state of the field.
    private Grid grid;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    // The current state of the pupulation
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_Y, DEFAULT_X, DEFAULT_Z);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param x Depth of the field. Must be greater than zero.
     * @param y Width of the field. Must be greater than zero.
     * @param z
     */
    public Simulator(int x, int y, int z)
    {
        if(y < 0 || x < 0 || z < 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            x = DEFAULT_Y;
            y = DEFAULT_X;
            z = DEFAULT_Z;
        }
        
        // TODO
        // Create a new ArrayList of animals.
        particles = new ArrayList<>();
        
        // Create a new grid with depth and width.
        if(x > 0 && y == 0 && z == 0) {
            grid = new Grid(x);
        } else if (x > 0 && y > 0 && z == 0) {
            grid = new Grid(x,y);
        } else if (x > 0 && y > 0 && z > 0) {
            grid = new Grid(x, y, z);
        } else {
            grid = new Grid(DEFAULT_X, DEFAULT_Y, DEFAULT_Z);
        }

        // Create a view of the state of each location in the field.
        view = new SimulatorView(x, y);
        
        view.setColor(Particle.class, Color.red);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int stepNum = 1; stepNum <= numSteps /*&& view.isViable(grid)*/; stepNum++) {
            simulateOneStep();
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     */
    public void simulateOneStep()
    {
        step++;
        List<Particle> newParticle = new ArrayList<>();
        for(Iterator<Particle> it = particles.iterator(); it.hasNext(); ) {
            Particle p = it.next();
            p.act();
            System.out.println("Particle done acting");
            /*if(! p.isInAction()) {
                it.remove();
            }*/
        }

        particles.addAll(newParticle);
        view.showStatus(step, grid);
    }
    
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        particles.clear();
                
        // Show the starting state in the view.
        view.showStatus(step, grid);
    }
    
    public void populate(int numPartic)
    {
        grid.clearAll();
        Location location = grid.getCenterLocation();
        for(int i = 0; i < numPartic; i++)
        {
            Particle p = new Particle(grid, location);
            particles.add(p);
            System.out.println("Added particle");
        }
    }
    
    //Checking the field
    //TODO
    /*
    private boolean isFieldValid()
    {
       ArrayList<Particle> animalsInField = getAnimalsInField();
        boolean result = true;
        
        for(Actor actor: animalsInField)
        {
            if(!animals.contains(actor))
            {
                result = false;
            }
        }
        return result;
    }
    

    //Checking the field List
    private boolean isListValid()
    {
        ArrayList<Animal> animalsInField = getAnimalsInField();
        boolean result = true;
        
        for(Animal animal: animals)
        {
            if(animal.isAlive())
            {
                if(!animalsInField.contains(animal))
                {
                    result = false;
                }   
            }
        }
        return result;
    }
    */
    //Checking through the field and add it into a list.
    private ArrayList<Particle> getParticleInField()
    {
        ArrayList<Particle> particleList = new ArrayList<>();
        
        int width = grid.getWidth();
        int depth = grid.getDepth();
        
        for(int iWidth = 0; iWidth < width; iWidth++)
        {
            for(int iDepth = 0; iDepth < depth; iDepth++)
            {
                Object objSelected = grid.getObjectAt(new Location(iDepth, iWidth, 0));
                if(objSelected != null)
                {
                    if(objSelected instanceof Particle)
                    {
                        particleList.add((Particle) objSelected);
                    }
                }
            }
        }
        return particleList;
    }
    
}