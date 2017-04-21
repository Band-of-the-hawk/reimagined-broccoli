package broccoli;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represent a logic of the simulator
 * 
 * @author Thomas Todal, Vinh Tran, Kristoffer Martinsen
 * @version 2017.03.31
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
    
    // Log info field to gather all the logging data.
    private final LogInfo logI;
    
    //Logger
    private final Logger particleLog;
    private final Logger stepLog;

    
    // Lists of particles in the field.
    private List<Particle> particles;
    // The current state of the field.
    private Grid grid;
    
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    //private SimulatorView view;
    // The current state of the pupulation
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_Z);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param x Depth of the field. Must be greater than zero.
     * @param y Width of the field. Must be greater than zero.
     * @param z Height of the field. Must be greater than zero.
     */
    public Simulator(int x, int y, int z)
    {
        if(x < 1 || y < 0 || z < 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            x = DEFAULT_X;
            y = DEFAULT_Y;
            z = DEFAULT_Z;
        }
        
        // Create a new ArrayList of particles.
        particles = new ArrayList<>();
        
        // Create the LogInfo object.
        this.logI = new LogInfo();
        
        this.particleLog = new Logger("particleposition");
        this.stepLog = new Logger("step-log");
        //particleLog.addLine("Step,Particle,x,y,z,");
        
        // Create a new grid with depth and width.
        if(x > 0 && y == 0 && z == 0) {
            grid = new Grid(x, logI);
        } else if (x > 0 && y > 0 && z == 0) {
            grid = new Grid(x, y, logI);
        } else if (x > 0 && y > 0 && z > 0) {
            grid = new Grid(x, y, z, logI);
        } else {
            grid = new Grid(DEFAULT_X, DEFAULT_Y, DEFAULT_Z, logI);
        }
        

        // Create a view of the state of each location in the field.
        //view = new SimulatorView(x, y);
        
        //view.setColor(Particle.class, Color.red);
        
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
        particleLog.writeToFile();
        stepLog.writeToFile();
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     */
    public void simulateOneStep()
    {
        step++;
        logI.setCurrentStep(step);
        for(Iterator<Particle> it = particles.iterator(); it.hasNext(); ) {
            Particle p = it.next();
            p.act();
            particleLog.addLine(gatherParticleData(p));
        }
        //stepLog.addLine(gatherStepData());

        //view.showStatus(step, grid);
    }
    
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        particles.clear();
                
        // Show the starting state in the view.
        //view.showStatus(step, grid);
    }
    
    public void populate(int numPartic)
    {
        Location location = grid.getCenterLocation();
        for(int i = 0; i < numPartic; i++)
        {
            Particle p = new Particle(grid, location, i, logI);
            particles.add(p);
            System.out.println("Added particle " + i);  //DEBUGGING
        }
    }
    
    private String gatherParticleData(Particle part)
    {
        String csvLine = "";
        csvLine += Integer.toString(step) + ",";
        csvLine += Integer.toString(part.getNumber()) + ",";
        csvLine += part.getLocation().toString() + ",";
        csvLine += getRootMeanSquare(part) + ",";
        
        return csvLine;
    }
    
    
    private String gatherStepData()
    {
        String csvLine = "";
        
        
        int gridX = grid.getXDepth();
        int gridY = grid.getYWidth();
        int gridZ = grid.getZHeight();
        for(int x = -gridX; x <= gridX; x++) {
            for(int y = -gridY; y <= gridY; y++) {
                for(int z = -gridZ; z <= gridZ; z++) {
                    
                }
            }
        }
        
        csvLine += Integer.toString(step);
        
        return csvLine;
    }
    
    private String getRootMeanSquare(Particle part)
    {
        String rMS = "";
        
        int xi = part.getLocation().getX();
        int yi = part.getLocation().getY();
        int zi = part.getLocation().getZ();
        
        rMS += Integer.toString(xi*xi + yi*yi + zi*zi);
        
        return rMS;
    }
}