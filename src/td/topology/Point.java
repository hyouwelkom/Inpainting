package td.topology;

public class Point {
    BoundingBox bb;
    public int i, j;

    public Point(BoundingBox _bb, int _i, int _j) {
        this.bb = _bb;
        this.i = i;
        this.j = j;
    }


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
        Edge[] outer = new Edge[4];
        Edge edge1 = new Edge();
        Edge edge2 = new Edge();
        Edge edge3 = new Edge();
        Edge edge4 = new Edge();
        if (this.onBorder())
        {
            if (this.onCorner())
            {

                //On check si c'est un coin inferieur ou supérieur
                if ( this.i == this.bb.getBB(0) )
                {

                    // Cas superieur : On check si le point est à gauche
                    if ( this.j == this.bb.getBB(3) )
                    {
                        //Cas Superieur : gauche
                        outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
                        outer[1] = new Edge(this.bb,1,this.i,this.j,1);
                    }
                    else
                    {
                        //Cas Superieur : droite
                        outer[0] = new Edge(this.bb,0,this.i,this.j,1);
                        outer[1] = new Edge(this.bb,1,this.i,this.j,1);
                    }
                }

                // Cas inferieur
                else
                    {

                    // Cas inferieur : On check si le point est à gauche
                    if (this.j == this.bb.getBB(1)) {

                        //Cas inferieur : gauche
                        outer[0] = new Edge(this.bb,0,this.i,this.j,1);
                        outer[3] = new Edge(this.bb,1, this.i, this.j,-1);
                    } else {
                        //Cas inferieur : droite
                        outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
                        outer[3] = new Edge(this.bb,1, this.i, this.j,-1);
                    }
                }
            }
            else
            {
                // On vérifie sur quelle bordure est le point

                // Bordure supérieure
                if ( this.i == this.bb.getBB(0) )
                {
                    outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
                    outer[0] = new Edge(this.bb,0,this.i,this.j,1);
                    outer[1] = new Edge(this.bb,1,this.i,this.j,1);
                }

                //Bordure inferieure
                if ( this.i == this.bb.getBB(2) )
                {
                    outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
                    outer[0] = new Edge(this.bb,0,this.i,this.j,1);
                    outer[3] = new Edge(this.bb,1, this.i, this.j,-1);
                }

                //Bordure droite
                if ( this.i == this.bb.getBB(1) )
                {
                    outer[0] = new Edge(this.bb,0,this.i,this.j,1);// TODO VIRGIIIILLLLLLEEEEEEEEEEE mes couilles
                    outer[1] = new Edge(this.bb,1,this.i,this.j,1);
                    outer[3] = new Edge(this.bb,1, this.i, this.j,-1);
                }

                //Bordure gauche
                if ( this.i == this.bb.getBB(3) )
                {
                    outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
                    outer[1] = new Edge(this.bb,1,this.i,this.j,1);
                    outer[3] = new Edge(this.bb, 1, this.i, this.j,-1);
                }
            }
        }
        else {

            // Cas point lambda
            outer[0] = new Edge(this.bb,0, this.i, this.j,1);
            outer[1] = new Edge(this.bb,1,this.i,this.j,1);
            outer[2] = new Edge(this.bb,0,this.i,this.j,-1);
            outer[3] = new Edge(this.bb,1, this.i, this.j,-1);
        }
        return outer;
    }

    @Override
    public String toString() { return "("+i+";"+j+")"; }
}
