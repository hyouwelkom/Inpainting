package topology;

public class Point {
    BoundingBox bb;
    public int i, j;

    public Point(BoundingBox _bb, int _i, int _j) {}

    public boolean isEqualTo(Point point) { return false; }
    public boolean onBorder() { return false; }
    public boolean onCorner() { return false; }
    public Edge[] outerEdges() { return null; }

    @Override
    public String toString() { return ""; }
}
