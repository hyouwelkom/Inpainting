package td.topology;

public class BoundingBox {
    public int[] bb;
    public int width, height, size;

    int nbEdgesHorizontal, nbEdgesVertical, nbEdges;

    public BoundingBox(BoundingBox boundingBox) {}
    public BoundingBox(java.awt.image.BufferedImage image) {}
    public BoundingBox(int[] bb_) {}
    public BoundingBox(java.lang.String fileName) {}

    public BoundingBox crop(Patch patch) { return this; }
}
