package td.topology;

import java.util.Arrays;

public class Tag {
    boolean[] active;
    Boundary boundary;
    int[] index;
    int nbActive;

    public Tag(Boundary _boundary) {
        boundary = _boundary;
        index = new int[boundary.bb.nbEdges];
        Arrays.fill(index, -1);//on remplit le tableau de -1
        int i = 0;
        for (Edge e : boundary.edges) {
            index[e.label] = i++;
        }
        nbActive = i;
        active = new boolean[nbActive];
        Arrays.fill(active, true);
    }

    Point SeedPoint() {
        for (int i = 0; i < active.length; i++)
            if (active[i] == true) {
                Edge edgeTMP = boundary.edges.get(i);
                Point pointTMP = edgeTMP.border()[0];
                if (pointTMP.onBorder() == true)  //Si le point est sur un bord on retourne le point
                    return pointTMP;
            }

        for (int i = 0; i < active.length; i++)
            if (active[i] == true) {
                Edge edgeTMP = boundary.edges.get(i);
                Point pointTMP = edgeTMP.border()[0];
                return pointTMP;
            }
        return null; // Si aucun des cas n'est bon, retourne nul.
    }

    int indexActiveOuterEdge(Point p) throws Exception {
        Edge[] test = p.outerEdges();
        for (Edge e : p.outerEdges()) { // pour tous les points en dehors des angles
            int i = index[e.label];
            if (i != -1) {
                if (boundary.edges.get(i).orientation == e.orientation) {
                    if (active[i]) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
