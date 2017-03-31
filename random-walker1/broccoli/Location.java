package broccoli;

/**
 * Represent a location in a rectangular grid.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Location
{
    // Row and column positions.
    private final int x;
    private final int y;
    private final int z;

    /**
     * Represent a row and column.
     * @param x The row.
     * @param y The column.
     * @param z
     */
    public Location(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Implement content equality.
     * @return 
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return x == other.getX() && y == other.getY() && z == other.getZ();
        }
        else {
            return false;
        }
    }
    
    /**
     * Return a string of the form row,column
     * @return A string representation of the location.
     */
    @Override
    public String toString()
    {
        return x + "," + y + "," + z;
    }
    
    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the location.
     */
    @Override
    public int hashCode()
    {
        return (x << 16) + y;
    }
    
    /**
     * @return The row.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return The column.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * 
     * @return 
     */
    public int getZ()
    {
        return z;
    }
}
