package td.topology;

import java.util.ArrayList;

public class Component {
    public ArrayList<Point> points;


    public Component(Tag tag, Point seedPoint) {
        Point point = seedPoint;

        while ((tag.indexActiveOuterEdge(point)!=-1)) {
         int index = tag.indexActiveOuterEdge(point);
         Edge outerEdge = tag.boundary.edges.get(index);
         points.add(point);
         point=outerEdge.border()[1];
         tag.active[index]=false;
         tag.nbActive--;
        }
}

    @Override
    public String toString() {
        return "";
    }
}
