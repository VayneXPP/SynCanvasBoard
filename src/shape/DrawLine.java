package Shape;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class DrawLine {
	
	public Shape myLine;
	
	public DrawLine() {
		
	}

	
	public DrawLine(Point startPt, Point endPt) {
		this.myLine = new Line2D.Double(startPt.x, startPt.y, endPt.x, endPt.y);
	}
	
	public Shape provideLine() {
		return myLine;
	}
}
