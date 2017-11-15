package td.topology;

import java.util.ArrayList;

public class Boundary
{
    public ArrayList<Edge> edges;// liste des arêtes du bord du masque
    BoundingBox bb;

    public Boundary(Mask mask) {

        edges = new ArrayList<Edge>();
        bb = mask;

        for (int i = 0; i < mask.width; i++) {
            for (int j = 0; j < mask.height - 1; j++) {
                if ((mask.val[i][j]) && (!mask.val[i][j + 1]))
                    edges.add(new Edge(mask, 0, i + 1, j + 1, -1));
                if ((!mask.val[i][j]) && (mask.val[i][j + 1]))
                    edges.add(new Edge(mask, 0, i, j + 1, 1));
            }
        }

        for (int i = 0; i < mask.width - 1; i++) {
            for (int j = 0; j < mask.height; j++) {
                if ((mask.val[i][j]) && (!mask.val[i + 1][j])) {
                    edges.add(new Edge(mask, 1, i + 1, j, 1));
                }
                if ((!mask.val[i][j]) && (mask.val[i + 1][j])) {
                    edges.add(new Edge(mask, 1, i + 1, j + 1, -1));
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = new String();
        for (Edge e : edges) {//pour chaque bords
            s += e + ";";//les affiches séparés par une virgule
        }
        return s;
    }
}
