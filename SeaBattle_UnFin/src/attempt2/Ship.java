package attempt2;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ship extends Pane{
	
	private int type;
	
	 double orgSceneX, orgSceneY;
	    double orgTranslateX, orgTranslateY;

	public int getType() {
		return type;
	}

	public Ship(int type) {
		//super(30,30);
		this.type = type;
		
		
		VBox ship = new VBox();
		for(int y = 0; y < type; y++) {
			Rectangle part = new Rectangle(30,30);
			part.setFill(Color.SADDLEBROWN);
			part.setStroke(Color.BLACK);
			ship.getChildren().add(part);
			ship.setTranslateY(50);
		}
		//grid.setAlignment(Pos.CENTER);
		getChildren().add(ship);
		//getChildren().add(grid);
		setPadding(new Insets(5,5,5,5));
		ship.setOnMousePressed(e-> {
            orgSceneX = e.getSceneX();
            orgSceneY = e.getSceneY();
            orgTranslateX = ((VBox)(e.getSource())).getTranslateX();
            orgTranslateY = ((VBox)(e.getSource())).getTranslateY();
            System.out.println();
		});
		
		ship.setOnMouseDragged(e-> {
            double offsetX = e.getSceneX() - orgSceneX;
            double offsetY = e.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            
            ((VBox)(e.getSource())).setTranslateX(newTranslateX);
            ((VBox)(e.getSource())).setTranslateY(newTranslateY);
            
            System.out.println(e.getSceneX() - orgSceneX);
		});
		
/*		setOnMouseDragged(e-> {
			relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
		});
		
	}
	
	public void move(int x, int y) {
		oldX = x * 30;
		oldY = y * 30;
		relocate(oldX, oldY);*/
	}
	
	

}
