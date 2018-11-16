package attempt2;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;


public class BattleField extends Parent{
	
	HBox board = new HBox();
	boolean enemy = false;

	private Field[][] battleField = new Field[10][10]; 

	public BattleField(boolean enemy) {
		super();
		this.enemy = enemy;
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5,5,5,5));
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				Field field = new Field(x,y);
				battleField[x][y] = field;
				
				grid.add(field, x, y);
			}
		}
		getChildren().add(grid);
	}

	

}
