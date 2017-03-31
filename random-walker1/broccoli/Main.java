package broccoli;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author ThomasS Todal
 */
public class Main extends Application
{
    private Stage stage;
    private Scene scene;
    private double height;
    private double width;
    private Pane root;
    
    public static void main(String[] args)
    {
        launch(args);
        Simulator simulator = new Simulator(10, 0, 0);
        simulator.simulate(100);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        /*this.stage = stage;
        
        // SET SIZE
        stage.setMinHeight(360);
        stage.setMinWidth(640);
        
        height = stage.getHeight();
        width = stage.getWidth();
        
        scene = new Scene(contentController());
        stage.setTitle("Diffusjon");
        stage.setScene(scene);
        stage.show();*/
    }
    
    public Parent contentController()
    {
        return null;
    }
}
