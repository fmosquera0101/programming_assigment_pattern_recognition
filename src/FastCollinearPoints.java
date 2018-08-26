import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FastCollinearPoints {
	private List<LineSegment> listLineSegments = new ArrayList<LineSegment>();
	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points){
		if(null == points){
			throw new IllegalArgumentException(); 
		}
		int lengthPoints = points.length;
		for (int i = 0; i < lengthPoints; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if(points[j].compareTo(points[i]) == 0){
					throw new IllegalArgumentException(); 
				}
			}
		}
		
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		int lengthPointsCopy = pointsCopy.length;
		for (Point point : points) {
			Arrays.sort(pointsCopy, point.slopeOrder());
			List<Point> listSlopePoints = new ArrayList<Point>();
			double slope = 0;
			double prevSlope = Double.NEGATIVE_INFINITY;
			for (int i = 1; i < lengthPointsCopy; i++) {
				slope = point.slopeTo(pointsCopy[i]);
				if(slope == prevSlope){
					listSlopePoints.add(pointsCopy[i]);
					
				}else{
					if(listSlopePoints.size() >= 3){
						listSlopePoints.add(point);
						
					}
					listLineSegments.clear();
					listSlopePoints.add(pointsCopy[i]);
				}
				prevSlope = slope;
				
			}
			if(listSlopePoints.size() >= 3){
				listSlopePoints.add(point);
				
			}

		}
	}
	// the number of line segments
	public int numberOfSegments(){
		return listLineSegments.size();
	}
	// the line segments
	public LineSegment[] segments(){
		return listLineSegments.toArray(new LineSegment[listLineSegments.size()]);
	}
}
