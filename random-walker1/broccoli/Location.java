package broccoli;

/**
 * Represent a location in a rectangular grid.
 * 
 * @author Vinh Tran, Thomas Todal, Kristoffer Martinsen
 * @version 31.03.2017
 */
public class Location
{
    // Row and column positions.
    private final int x;
    private final int y;
    private final int z;

    /**
     * Represent a row and column.
     * @param x The depth.
     */
    public Location(int x)
    {
        this.x = x;
        this.y = 0;
        this.z = 0;
    }
    
    /**
     * Represent a row and column.
     * @param x The depth.
     * @param y The width.
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    
    /**
     * Represent a depth, width and height
     * @param x The depth.
     * @param y The width.
     * @param z The height
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
        return ((x << 16) + y) << 16 + z;
    }
    
    /**
     * The depth of the field
     * @return The depth of the field
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * The width of the field
     * @return The width of the field
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * The hight of the field
     * @return The hight of the field
     */
    public int getZ()
    {
        return z;
    }
}
