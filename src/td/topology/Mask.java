package td.topology;

public class Mask extends BoundingBox {
    public boolean[][] val;

    public Mask(Matrix matrix, Color color) {
        super();

    }

    public Mask(String fileName, Color color) {
        super();

    }

    public boolean touchedBy(Point point) {

        return false;
    }
}
