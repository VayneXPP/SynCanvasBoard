package shape;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class DrawRect {
	public int width;
	public int height;
	public int upperLeftX;
	public int upperLeftY;
	public Shape myRect;
		
	public DrawRect() {
		
	}
	
	public DrawRect(Point startPt, Point endPt) {
		this.upperLeftX = Math.min(startPt.x, endPt.x);
		this.upperLeftY = Math.min(startPt.y, endPt.y);;
		this.width = Math.abs(startPt.x - endPt.x);
		this.height = Math.abs(startPt.y - endPt.y);
	}

	public Shape provideRec(){
		myRect = new Rectangle2D.Double(upperLeftX, upperLeftY,Math.max(width,height), Math.min(width, height));
		return myRect;
		
	}
	
	
}