package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
    public void start(Stage stage) throws IOException {
		/*
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Principal.fxml"));
		loader = fxmlLoader.load();
		*/
		
        // Create the FXMLLoader 
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "./fxml/Principal.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
 
        // Create the Pane and all Details
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A simple FXML Example");
        // Display the Stage
        
        
        // para o programacao abrir de acordo com a dimensao da tela do computador
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
