package controladores;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Principal {
	
	
	BorderPane root = new BorderPane();
 
	private void initialize() {

			root.setPrefSize(200, 200);
		
			System.out.println("classe principal inicializada");
		
		
	}
	
	public BorderPane getBorderPane() {
		return root;
	}
	
	

}
