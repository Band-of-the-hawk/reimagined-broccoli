import java.util.ArrayList;

/**
 * Created by Kristoffer on 02.04.2017.
 */
public class Grid {

    private final int WIDTH, HEIGHT, DEPTH;
    private int x;
    private int y;
    private int z;
    private String grid[][][];
    private GridCell gridCell;
    private ArrayList<GridCell> adjacentCell;

    public Grid (int width, int height, int depth) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.DEPTH = depth;

        adjacentCell = new ArrayList<>();
    }

    public void setCenter() {
        setLocation(0, 0, 0);
    }

    public void setLocation(int xPos, int yPos, int zPos) {
        x = xPos;
        y = yPos;
        z = zPos;
    }

    public String getCellState(int x, int y, int z) {
        return gridCell.getState();
    }

    public void fillGrid() {
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                for (int z = 0; z < DEPTH; z++) {
                    gridCell.setState("Empty");
                }
            }
        }
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getDEPTH() {
        return DEPTH;
    }


}
