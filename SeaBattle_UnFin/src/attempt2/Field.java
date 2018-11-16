package attempt2;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Field extends Rectangle{
	
	private Ship ship;
	
	public boolean hasShip() {
		return ship != null;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
	public Field(int x, int y) {
		super(30,30);
		
		setFill(Paint.valueOf("#336699"));
		setStroke(Color.BLACK);
		
		setX(x);
		setY(y);

		setOnMousePressed(e-> {System.out.println(e.getSceneX());
		//mouseX = e.getSceneX();
		//mouseY = e.getSceneY();
	});
	}
	
	

}
