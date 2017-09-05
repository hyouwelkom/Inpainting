package topology;

public class Edge {
    private static int[][] v;

    private BoundingBox bb;
    private int direction, i, j;
    public int label, orientation;

    public Edge(BoundingBox _bb, int _direction, int _i, int _j, int _orientation) {}

    public Point[] border() { return null; }

    @Override
    public String toString() { return ""; }
}
