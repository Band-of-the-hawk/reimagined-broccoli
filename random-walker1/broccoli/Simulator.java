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
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;

     //TODO
    // Lists of animals in the field.
    private List<Particle> particle;
    // The current state of the field.
    private Grid grid;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    // The current state of the pupulation 
    //private PopulationGenerator populationGenerator;
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        // TODO
        // Create a new ArrayList of animals.
        particle = new ArrayList<>();
        
        // Create a new field with depth and width.
        grid = new Grid(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        
        //TODO
        // Create randomly populate in the field with foxes and rabbits.
        //this.populationGenerator = new PopulationGenerator(grid, animals, view);
        
        // TODO
        //Setting color on Animal(Rabbit, Fox)
        //populationGenerator.setColors(Color.GREEN, Color.RED);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(grid); step++) {
            simulateOneStep();
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     * TODO
     */
    public void simulateOneStep()
    {
        
        
        step++;
        List<Particle> newParticle = new ArrayList<>();
        for(Iterator<Particle> it = particle.iterator(); it.hasNext(); ) {
            Particle particle = it.next();
            particle.act(newParticle);
            if(! particle.isInAction()) {
                it.remove();
            }
        }
  
        particle.addAll(newParticle);
        view.showStatus(step, grid);
      
    /*   
        // Checking if the field is valid.
            if(isFieldValid())
            {
                System.out.println("Field is valid");
            }
            else
            {
                System.out.println("Field is not valid");
            }
        // Checking if the list of the field is valid.
            if(isListValid())
            {
                System.out.println("List is valid");
            }
            else
            {
                System.out.println("List is not valid");
            }
    */
    }
        /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        particle.clear();
        //populationGenerator.populate();
                
        // Show the starting state in the view.
        view.showStatus(step, grid);
    }
    
    //Checking the field
    //TODO
    /*
    private boolean isFieldValid()
    {
       //ArrayList<Actor> animalsInField = getAnimalsInField();
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
                Object objSelected = grid.getObjectAt(new Location(iDepth, iWidth));
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