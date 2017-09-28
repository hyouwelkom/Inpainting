package td.topology;

public class Point {
    BoundingBox bb;
    public int i, j;

    public Point(BoundingBox _bb, int _i, int _j) {}


    // Compare les coordonnées de chaque point, retourne true si égales
    public boolean isEqualTo(Point point) {
        if (this.bb.equals(point.bb)) {
            if (this.i == point.i) {
                if (this.j == point.j)
                    return true;
                else
                    return false;
            } else
                return false;
        }
        else
            return false;
    }


    public boolean onBorder() {
        if (onCorner())
            return true;
        if ( this.i == this.bb.getBB(0) )
            return true;
        if ( this.i == this.bb.getBB(2) )
            return true;
        if ( this.j == this.bb.getBB(1) )
            return true;
        if ( this.j == this.bb.getBB(3) )
            return true;
        return false;
    }

    public boolean onCorner() {
        for (int i=0;i<3;i+=2){
            if ( this.i == this.bb.getBB(i) ) {
                for (int j=1;j<4;j+=2){
                    if ( this.j == this.bb.getBB(j) )
                        return true;
                }
            }
        }

        return false;
    }
    public Edge[] outerEdges() {
        return null; }

    @Override
    public String toString() { return "("+i+";"+j+")"; }
}
