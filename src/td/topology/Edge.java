package td.topology;

public class Edge {

    private static int[][] v = new int[][]{
            {1,0},
            {0,1}
    };

    private BoundingBox bb;
    private int direction, i, j;
    public int label;
    public int orientation;

    public Edge() { // Constructeur vide pour regler le problème d'initialisation dans Point.outerEdge()
    }

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
    }

    public Point[] border() { // On créer un nouveau point et on lui associe ses coordonées en appliquant la formule {i+orientation*vecteur direction}
        Point p1 = new Point(this.bb, this.i, this.j);
        int p2i,p2j;
        p2i = this.i+this.orientation*v[direction][0];
        p2j = this.j+this.orientation*v[direction][1];
        Point p2 = new Point(this.bb, p2i, p2j);
        // On rajoute les points dans le tableau de retour
        Point[] tabPoint = new Point[]{p1,p2};
        return tabPoint;
    }

    @Override //retour sous la forme "(i,j)(orientation,direction)"
    public String toString() { return "("+i+","+j+")("+orientation+","+direction+")"; }
}
