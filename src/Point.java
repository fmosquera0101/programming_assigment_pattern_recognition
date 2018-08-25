import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;


public class Point implements Comparable<Point> {

	private final int x;
	private final int y;

	// constructs the point (x, y)
	public Point(int x, int y)   {
		this.x = x;
		this.y =y;

	}
	// draws this point
	public   void draw(){
		StdDraw.point(x, y);
	}
	// draws the line segment from this point to that point
	public   void drawTo(Point that){
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
	// string representation
	public String toString(){
		StringBuilder stbPoint = new StringBuilder();
		stbPoint.append("(");
		stbPoint.append(this.x);
		stbPoint.append(", ");
		stbPoint.append(this.y);
		stbPoint.append(")");
        return stbPoint.toString();

	}

	// compare two points by y-coordinates, breaking ties by x-coordinates
	public int compareTo(Point that){
		if(this.y < that.y){
			return -1;
		}
		if(this.y > that.y){
			return 1;
		}
		if(this.x < that.x){
			return -1;
		}
		if(this.x > that.x){
			return 1;
		}
		return 0;
	}
	// the slope between this point and that point
	public double slopeTo(Point that){
		if(this.x == that.x && this.y == that.y){
			return Double.NEGATIVE_INFINITY;
		}else if(this.x - that.x == 0.0){
			return Double.POSITIVE_INFINITY;
		}else if(this.y - that.y == 0.0){
			return 0.0;
		}else{
			return (double)(this.y - that.y) / (double)(this.x - that.x);
		}
	}
	// compare two points by slopes they make with this point
	public Comparator<Point> slopeOrder(){
		return new ComparatorSlopeOrder();
	}
	
	private class ComparatorSlopeOrder implements Comparator<Point>{
		Point point = new Point(x, y);
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.slopeTo(point) < o2.slopeTo(point)){
				return -1;
			}
			if(o1.slopeTo(point) > o2.slopeTo(point)){
				return 1;
			}
			return 0;
		}
		
	}


}
