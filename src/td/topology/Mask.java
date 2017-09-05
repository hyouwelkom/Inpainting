package topology;

public class Mask extends BoundingBox {
    public boolean[][] val;

    public Mask(Matrix matrix, Color color) {}
    public Mask(java.lang.String fileName, Color color) {}

    public boolean touchedBy(Point point) { return false; }
}
