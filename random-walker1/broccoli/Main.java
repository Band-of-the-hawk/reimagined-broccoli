package broccoli;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Vinh Tran, Thomas Todal, Kristoffer Martinsen
 * @version 31.03.2017
 */
public class Main /*extends Application*/
{
    private Stage stage;
    private Scene scene;
    private double height;
    private double width;
    private Pane root;
    
    public static void main(String[] args)
    {
        //launch(args);
        Simulator simulator = new Simulator(20, 20, 20);
        simulator.populate(1);
        simulator.simulate(1000);
    }

    /*@Override
    public void start(Stage stage) throws Exception
    {
        this.stage = stage;
        
        // SET SIZE
        stage.setMinHeight(360);
        stage.setMinWidth(640);
        
        height = stage.getHeight();
        width = stage.getWidth();
        
        scene = new Scene(contentController());
        stage.setTitle("Diffusjon");
        stage.setScene(scene);
        stage.show();
    }*/
    
    /*public Parent contentController()
    {
        return null;
    }*/
}
