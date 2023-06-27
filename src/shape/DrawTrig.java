package shape;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

public class DrawTrig {
	
	public int x_min, x_max, y_min, y_max;
	public Shape myTrig;
		
	public DrawTrig() {
		
	}
	
	public DrawTrig(Point startPt, Point endPt) {
		this.x_min = Math.min(startPt.x, endPt.x);
		this.x_max = Math.max(startPt.x, endPt.x);
		this.y_min = Math.min(startPt.y, endPt.y);
		this.y_max = Math.max(startPt.y, endPt.y);
	}

	public Shape provideTrig(){
		int []xpoints = {x_min, (x_min + x_max)/2, x_max};
		int []ypoints = {y_max, y_min, y_max};
		myTrig = new Polygon(xpoints, ypoints, 3);
		return myTrig;
		
	}
	
	
}
