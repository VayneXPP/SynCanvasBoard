package shape;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class DrawTextBox {
	
	public int width;
	public int height;
	public int upperLeftX;
	public int upperLeftY;
	public Shape myRect;
		
	public DrawTextBox() {
		
	}
	
	public DrawTextBox(Point startPt, Point endPt) {
		this.upperLeftX = Math.min(startPt.x, endPt.x);
		this.upperLeftY = Math.min(startPt.y, endPt.y);;
		this.width = Math.abs(startPt.x - endPt.x);
		this.height = Math.abs(startPt.y - endPt.y);
	}

	public Shape provideTextBox(){
		// refer to: https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
		myRect = new RoundRectangle2D.Double(upperLeftX, upperLeftY,Math.max(width,height), Math.min(width, height),50, 50);
		return myRect;
		
	}

}
