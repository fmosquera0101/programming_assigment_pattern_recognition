
public class LineSegment {
	// constructs the line segment between points p and q
	private final Point p;
	private final Point q;
	public LineSegment(Point p, Point q){
		if(p == null || q == null){
			throw new NullPointerException("Agument is null");
		}
		this.p = p;
		this.q = q;
	}
	// draws this line segment
	public   void draw(){
		p.drawTo(q);
	}
	// string representation
	public String toString(){
		return p +"->"+q;
	}
	
	/**
     * Throws an exception if called. The hashCode() method is not supported because
     * hashing has not yet been introduced in this course. Moreover, hashing does not
     * typically lead to good *worst-case* performance guarantees, as required on this
     * assignment.
     *
     * @throws UnsupportedOperationException if called
     */
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

}
