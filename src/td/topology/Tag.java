package topology;

public class Tag {
    boolean[] active;
    Boundary boundary;
    int[] index;
    int nbActive;

    public Tag(Boundary _boundary) {}
    int indexActiveOuterEdge(Point point) { return 0; }
    Point SeedPoint() { return null; }
}
