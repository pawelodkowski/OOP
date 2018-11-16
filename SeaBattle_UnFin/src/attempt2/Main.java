package attempt2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	Ship ship;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		BattleField player = new BattleField(false);
		BattleField enemy = new BattleField(true);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(new Label("BATTLESHIP!"));
		borderPane.setLeft(player);
		borderPane.setRight(enemy);
		borderPane.setBottom(new HBox(new Ship(4), new Ship(3), new Ship(3), new Ship(2),
				new Ship(2),new Ship(2),new Ship(1),new Ship(1),new Ship(1),new Ship(1)));

		Scene scene = new Scene(borderPane);
    	stage.setScene(scene);
    	stage.setTitle("SeaBattle!");
    	stage.setResizable(false);
    	stage.show();
    	

	}
	

	
	
	

}
