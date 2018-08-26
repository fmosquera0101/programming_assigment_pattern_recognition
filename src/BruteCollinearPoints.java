import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BruteCollinearPoints {
	private List<LineSegment> listLineSegments = new ArrayList<LineSegment>();
	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points){
		if(null == points){
			throw new IllegalArgumentException(); 
		}
		int lengthPoints = points.length;
		for (int i = 0; i < lengthPoints; i++) {
			if(null == points[i]){
				throw new IllegalArgumentException(); 
			}
			
		}
		
		for (int i = 0; i < lengthPoints; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if(points[j].compareTo(points[i]) == 0){
					throw new IllegalArgumentException(); 
				}
			}
		}
		
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		Arrays.sort(pointsCopy);
		int lengthPointsCopy = pointsCopy.length;
		for (int i = 0; i < lengthPointsCopy; i++) {
			for (int j = i + 1; j < lengthPointsCopy; j++) {
				for (int k = j + 1; k < lengthPointsCopy; k++) {
					for (int l = k + 1; l < lengthPointsCopy; l++) {
						Point p = pointsCopy[i];
						Point q = pointsCopy[j];
						Point r = pointsCopy[k];
						Point s = pointsCopy[l];
						if(p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)){
							listLineSegments.add(new LineSegment(p, s));
						}
					}
				}
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
