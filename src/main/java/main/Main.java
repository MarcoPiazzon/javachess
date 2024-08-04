package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class for launching the JavaFX application.
 * Sets up the primary stage and loads the initial FXML view.
 */
public class Main extends Application {
    // Controller handle for accessing the application controller
    static Controller myControllerHandle;

    /**
     * Entry point for the JavaFX application.
     * Initializes the primary stage and loads the FXML file.
     *
     * @param stage the primary stage for this application, onto which the application scene is set
     * @throws IOException if there is an error loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file and create the root node
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
        Parent root = loader.load();

        // Get the controller for the FXML file
        myControllerHandle = loader.getController();

        // Create the scene with the root node and set it on the stage
        Scene scene = new Scene(root);
        stage.setTitle("javachess"); // Set the title of the application window
        stage.setScene(scene); // Set the scene on the stage
        stage.show(); // Display the stage
    }

    /**
     * Main method for launching the JavaFX application.
     * This method is called by the JVM to start the application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        launch(); // Launch the JavaFX application
    }
}
