package src;
/**
 * Created by Kristoffer on 02.04.2017.
 */
public class Simulator {
    private Particle particle;
    private Grid grid;

    public Simulator() {
        this.particle = new Particle();
        this.grid = new Grid(15, 15, 15);
        this.grid.fillGrid();
        this.grid.setGrid();
        this.grid.dummyCheckGrid();
    }

    public void populate(int amount) {
        for(int i = 0; i < amount; i++) {

        }
    }
}
