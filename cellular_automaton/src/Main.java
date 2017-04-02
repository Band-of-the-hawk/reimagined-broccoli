/**
 * Created by Kristoffer on 02.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.populate(10);
        simulator.act(100);
    }
}
