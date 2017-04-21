package src;
import java.util.ArrayList;


/**
 * Created by Kristoffer on 02.04.2017.
 */
public class Grid {

    private final int WIDTH, HEIGHT, DEPTH;
    private GridCell grid[][][];
    //private GridCell gridCell;
    private ArrayList<GridCell> adjacentCell;

    public Grid (int width, int height, int depth) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.DEPTH = depth;
        this.grid = new GridCell[WIDTH][HEIGHT][DEPTH];

        adjacentCell = new ArrayList<>();
    }

    public Boolean getCellState(int x, int y, int z) {
        return grid[x][y][z].getState();
    }


    public void fillGrid() {
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                for(int z = 0; z < DEPTH; z++) {
                    grid[x][y][z] = new GridCell();
                }
            }
        }
    }

    public void setGrid() {
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                for(int z = 0; z < DEPTH; z++) {
                    grid[x][y][z].setState(false);
                }
            }
        }
    }

    public void dummyCheckGrid() {
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                for(int z = 0; z < DEPTH; z++) {
                    System.out.println("x: " + x
                            + "y: " + y
                            + "z: " + z
                            + "--> " + grid[x][y][z].getState());
                }
            }
        }
    }
}
