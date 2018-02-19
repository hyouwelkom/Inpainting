package td.topology;

import java.util.ArrayList;
import java.util.List;

public class Component {
    public ArrayList<Point> points;


    public Component(Tag tag, Point seedPoint) throws Exception {
        Point point = seedPoint;

        while ((tag.indexActiveOuterEdge(point)!=-1)) {
         int index = tag.indexActiveOuterEdge(point);
         Edge outerEdge = tag.boundary.edges.get(index);
         points.add(point);
         point=outerEdge.border()[1];
         tag.active[index]=false;
         tag.nbActive--;
        }
        if (!(seedPoint.isEqualTo(point))){
            points.add(point);
        }
}

    @Override
    public String toString() {
        String s = "(";
        if(!(points.isEmpty())){
            s+=points.get(0);
            for (Point p : points) {
                s+="," + p;
            }
            s+=")";
            }
            return s;
        }

    public List<Point> getPoints() {
        return points;
    }
}
