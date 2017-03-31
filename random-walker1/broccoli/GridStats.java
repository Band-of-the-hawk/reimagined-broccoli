package broccoli;

import java.util.HashMap;

/**
 * This class collects and provides some statistical data on the state 
 * of a field. It is flexible: it will create and maintain a counter 
 * for any class of object that is found within the field.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class GridStats
{
    // Counters for each type of entity (fox, rabbit, etc.) in the simulation.
    private HashMap<Class, Counter> counters;
    // Whether the counters are currently up to date.
    private boolean countsValid;

    /**
     * Construct a FieldStats object.
     */
    public GridStats()
    {
        // Set up a collection for counters for each type of animal that
        // we might find
        counters = new HashMap<>();
        countsValid = true;
    }

    /**
     * Get details of what is in the field.
     * @param grid
     * @return A string describing what is in the field.
     */
    public String getPopulationDetails(Grid grid)
    {
        StringBuffer buffer = new StringBuffer();
        if(!countsValid) {
            generateCounts(grid);
        }
        for(Class key : counters.keySet()) {
            Counter info = counters.get(key);
            buffer.append(info.getName());
            buffer.append(": ");
            buffer.append(info.getCount());
            buffer.append(' ');
        }
        return buffer.toString();
    }
    
    /**
     * Invalidate the current set of statistics; reset all 
     * counts to zero.
     */
    public void reset()
    {
        countsValid = false;
        for(Class key : counters.keySet()) {
            Counter count = counters.get(key);
            count.reset();
        }
    }

    /**
     * Increment the count for one class of animal.
     * @param animalClass The class of animal to increment.
     */
    public void incrementCount(Class animalClass)
    {
        Counter count = counters.get(animalClass);
        if(count == null) {
            // We do not have a counter for this species yet.
            // Create one.
            count = new Counter(animalClass.getName());
            counters.put(animalClass, count);
        }
        count.increment();
    }

    /**
     * Indicate that an animal count has been completed.
     */
    public void countFinished()
    {
        countsValid = true;
    }

    /**
     * Determine whether the simulation is still viable.
     * I.e., should it continue to run.
     * @param grid
     * @return true If there is more than one species alive.
     */
    public boolean isViable(Grid grid)
    {
        // How many counts are non-zero.
        int nonZero = 0;
        if(!countsValid) {
            generateCounts(grid);
        }
        for(Class key : counters.keySet()) {
            Counter info = counters.get(key);
            if(info.getCount() > 0) {
                nonZero++;
            }
        }
        return nonZero > 1;
    }
    
    /**
     * Generate counts of the number of foxes and rabbits.
     * These are not kept up to date as foxes and rabbits
     * are placed in the field, but only when a request
     * is made for the information.
     * @param grid The field to generate the stats for.
     */
    private void generateCounts(Grid grid)
    {
        reset();
       for(int x = 0; x < grid.getDepth(); x++) {
            for(int y = 0; y < grid.getWidth(); y++) {
                for(int z = 0; z < grid.getHeight(); z++) {
                
                Object particle = grid.getObjectAt(x,y,z);
                if(particle != null) {
                    incrementCount(particle.getClass());
                }
                }
            }
        }
        countsValid = true;
    }
}
