package Shape;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class DrawCircle {
	
	public int width;
	public int height;
	public int upperLeftX;
	public int upperLeftY;
	public Shape myCircle;
		
	public DrawCircle() {
		
	}
	
	public DrawCircle(Point startPt, Point endPt) {
		this.upperLeftX = Math.min(startPt.x, endPt.x);
		this.upperLeftY = Math.min(startPt.y, endPt.y);
		this.width = Math.abs(startPt.x - endPt.x);
		this.height = Math.abs(startPt.y - endPt.y);		
	}
			
	
	public Shape provideCircle() {
		myCircle = new Ellipse2D.Double(upperLeftX,upperLeftY, Math.max(width,height), Math.min(width, height));
		return myCircle;
	}	
	
}
