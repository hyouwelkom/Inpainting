package td.topology;

public class Patch {
    public BoundingBox boundingBox;
    public Point point;

    public Patch(Point point,int halfwidth,BoundingBox window)
    {
       this.point= point;
        // On initialise la boundingBox du patch avec la taille du halfwidth et des coordonnées du point
        this.boundingBox=new BoundingBox(new int[]{
                Math.max(0,point.i-halfwidth)-point.i, //Par rapport à Point.i pour le haut du patch
                Math.max(0,point.j-halfwidth)-point.j, //Par rapport à Point.j pour le bas du patch
                Math.min(window.width,point.i+halfwidth)-point.i, //Par rapport à Point.i pour la gauche du patch
                Math.min(window.height,point.j+halfwidth)-point.j}); //Par rapport à Point.i pour la droite du patch
    }
}
