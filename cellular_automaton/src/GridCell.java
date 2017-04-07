package src;

/**
 * Created by Kristoffer on 02.04.2017.
 */
public class GridCell {
    private Boolean state;
    private int particlesInCell;

    public GridCell() {
        particlesInCell = 0;
    }

    public void setState(Boolean stateToSet) {
        this.state = stateToSet;
    }

    public Boolean getState() {
        return state;
    }

    public int getParticlesInCell() {
        return particlesInCell;
    }

    public void setParticlesInCell(int particles) {
        this.particlesInCell = particles;
    }

}
