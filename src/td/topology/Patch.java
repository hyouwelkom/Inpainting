package td.topology;

public class Patch {
    public BoundingBox boundingBox;
    public Point point;

    public Patch(Point point, int midlarg, BoundingBox window)
    {
       this.point= point;
        int[] bb_patch;
        // On init la bb du patch avec la taille du midlarg et les coordonnées du point
        this.boundingBox = new BoundingBox(

                bb_patch = new int[]{
                        Math.max(0, point.i - midlarg) - point.i, Math.max(0, point.j - midlarg) - point.j,//Haut et bas du patch  par rapport à Point.i et Point.j
                        Math.min(window.width, point.i + midlarg) - point.i, Math.min(window.height, point.j + midlarg) - point.j});//Gauche et droite par rapport à Point.i et Point.j
    }
}
