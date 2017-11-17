package td.topology;

public class Edge {

    private static int[][] v = new int[][]{
            {1,0},
            {0,1}
    };
    public int label;
    public int orientation;
    private BoundingBox bb;
    private int direction, i, j;

    public Edge(BoundingBox bb, int direction, int i, int j) { // Constructeur officiel
        this.bb = bb;
        this.direction = direction;
        this.i = i;
        this.j = j;
    }

    public Edge(BoundingBox _bb, int _direction, int _i, int _j, int _orientation) {
        this.bb = bb;
        this.direction = direction;
        this.i = i;
        this.j = j;
        this.orientation = orientation;

        if (direction != 0) { // Si point pas orienté
            label = bb.nbEdgesH + (i + (orientation - 1) / 2 * v[direction][0]) * bb.height + (j + (orientation - 1) / 2 * v[direction][1]);
        } else {
            label = (i + (orientation - 1) / 2 * v[direction][0]) + (j + (orientation - 1) / 2 * v[direction][1]) * bb.width;
        }
    }

    public Point[] border() { // On créer un nouveau point et on lui associe ses coordonées en appliquant la formule {i+orientation*vecteur direction}
        Point[] op = new Point[2];
        op[0] = new Point(bb, i, j);
        op[1] = new Point(bb, i + orientation * v[direction][0], j + orientation * v[direction][1]);
        return op;
    }

    @Override //retour sous la forme "(i,j)(orientation,direction)"
    public String toString() {
        Point[] sommets = border();
        return sommets[0] + "-" + sommets[1];
    }

}
