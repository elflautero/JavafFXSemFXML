package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ControladorPrincipal implements Initializable {
	
	@FXML AnchorPane apPrincipal;
	WebView wv;
	
	
	TabPane tpLateralDireita = new TabPane();
	TabPane tpLateralEsquera = new TabPane();
	
	Tab tabLD1 = new Tab("1");
	Tab tabLD2 = new Tab("2");
	
	Tab tabLE1 = new Tab("1");
	Tab tabLE2 = new Tab("2");
	
	
	Pane pLD1 = new Pane();
	Pane pLD2 = new Pane();
	Pane pLE1 = new Pane();
	Pane pLE2 = new Pane();
	
	StackPane spConversorCoordenadas = new  StackPane();
	StackPane spCentroTabPanes = new  StackPane();
	Pane pConCoor  = new Pane ();

	Pane pSuperior = new Pane();
	
	Button btn = new Button("clique");
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		wv  = new WebView();
		WebEngine webEngine = wv.getEngine();
		
		webEngine.load(getClass().getResource("/controladores/mapa.html").toExternalForm());
		
		AnchorPane.setTopAnchor(wv, 0.0);
		AnchorPane.setRightAnchor(wv, 0.0);
		AnchorPane.setLeftAnchor(wv, 0.0);
		AnchorPane.setBottomAnchor(wv, 0.0);
		
		pLD1.setPrefSize(90, 300);
		pLD1.setStyle("-fx-background-color: green;");
		
		pLD2.setPrefSize(90, 300);
		pLD2.setStyle("-fx-background-color: blue;");
		
		pLD1.getChildren().add(btn);
		
		tabLD1.setContent(pLD1);
		tabLD2.setContent(pLD2);
		
		
		
		pLE1.setPrefSize(90, 300);
		pLE1.setStyle("-fx-background-color: red;");
		
		pLE2.setPrefSize(90, 300);
		pLE2.setStyle("-fx-background-color: orange;");
		
		tabLE1.setContent(pLE1);
		tabLE2.setContent(pLE2);
		
		tpLateralDireita.getTabs().addAll(tabLD1, tabLD2);
		tpLateralEsquera.getTabs().addAll(tabLE1, tabLE2);
		
		
		AnchorPane.setTopAnchor(tpLateralEsquera, 100.0);
		AnchorPane.setLeftAnchor(tpLateralEsquera, 10.0);
		
		AnchorPane.setTopAnchor(tpLateralDireita, 100.0);
		AnchorPane.setRightAnchor(tpLateralDireita, 10.0);

		pConCoor.setMinSize(800, 80);
		pConCoor.setMaxSize(800, 80);
	
		pConCoor.setStyle("-fx-background-color: yellow;");
		
		AnchorPane.setRightAnchor(spConversorCoordenadas, 0.0);
		AnchorPane.setLeftAnchor(spConversorCoordenadas, 0.0);
		AnchorPane.setBottomAnchor(spConversorCoordenadas, 15.0);
		
		spConversorCoordenadas.getChildren().add(pConCoor);
		spConversorCoordenadas.setDisable(true);
	    StackPane.setAlignment(pConCoor, Pos.TOP_CENTER);
	    
	    pSuperior.setPrefSize(600, 25);
	    pSuperior.setStyle("-fx-background-color: brown;");
	    
	    AnchorPane.setTopAnchor(pSuperior, 0.0);
		AnchorPane.setRightAnchor(pSuperior, 0.0);
		AnchorPane.setLeftAnchor(pSuperior, 0.0);
		
		AnchorPane.setTopAnchor(spCentroTabPanes, 50.0);
		AnchorPane.setRightAnchor(spCentroTabPanes, 110.0);
		AnchorPane.setLeftAnchor(spCentroTabPanes, 110.0);
		AnchorPane.setBottomAnchor(spCentroTabPanes, 105.0);
		
		Pane p = new Pane ();
		p.setStyle("-fx-background-color: red;");
		
		spCentroTabPanes.getChildren().add(p);
		spCentroTabPanes.setDisable(true);
	    StackPane.setAlignment(spCentroTabPanes, Pos.TOP_CENTER);
	    
		apPrincipal.getChildren().addAll( wv, tpLateralEsquera, tpLateralDireita, spConversorCoordenadas, pSuperior,spCentroTabPanes);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		     
		        if (p.getTranslateY() == 0.0)
		        	p.setTranslateY(800);
		        		else 
		        			p.setTranslateY(0.0);
		    }
		});
		
	}
}


//String content = retrieveContent(getClass().getResourceAsStream("/html/mapa.html"));

//webEngine.loadContent(content);

//webEngine.load("https://docs.oracle.com/javafx/2/webview/jfxpub-webview.htm");

//webEngine.load(this.getClass().getResource("/html/mapa.html").toExternalForm());

//original
// webEngine.load(getClass().getResource("/html/mapas/Principal/index.html").toExternalForm());

//System.out.println(System.getProperty("java.class.path"));
