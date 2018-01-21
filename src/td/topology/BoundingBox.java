package td.topology;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoundingBox {
    protected int[] bb;
    protected int width, height, size;

    protected int nbEdgesH, nbEdgesV, nbEdges;

    protected BoundingBox() {
        this.bb = new int[4];
    }

    public BoundingBox(BoundingBox boundingBox) {
        this.bb = boundingBox.bb;
        this.width = boundingBox.width;
        this.height = boundingBox.height;
        this.size = boundingBox.size;
        this.nbEdgesH = boundingBox.nbEdgesH;
        this.nbEdgesV = boundingBox.nbEdgesV;
        this.nbEdges = boundingBox.nbEdges;
    }
    public BoundingBox(int[] bb_) {
        this.bb = bb_;
        this.recalculVar();
    }

    public BoundingBox(BufferedImage image) {
        this();
        this.fromBufferedImage(image);
        this.recalculVar();
    }

    public BoundingBox(String fileName) throws IOException {
        //this(ImageIO.read(new File(fileName)));
        this();
        BufferedImage image = ImageIO.read(new File(fileName));
        if (image == null) throw new IOException("Fichier non trouvé!");

        this.fromBufferedImage(image);
        this.recalculVar();
    }

    private void recalculVar() {
        this.width = this.bb[2];
        this.height = this.bb[3];
        this.size = this.width * this.height;
        this.nbEdgesH = 2;
        this.nbEdgesV = 2;
        this.nbEdges = this.nbEdgesH + this.nbEdgesV;
    }

    private void fromBufferedImage(BufferedImage image) {
        this.bb[0] = 0;
        this.bb[1] = 0;
        this.bb[2] = image.getWidth();
        this.bb[3] = image.getHeight();
    }
    public int getBB(int i) {
        return bb[i];
    }

    public int[] getBb() {
        return this.bb;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int get(int i) {
        return bb[i];
    }

    public BoundingBox crop(Patch p) {
        int tab[] = { bb[0]-p.boundingBox.bb[0], bb[1]-p.boundingBox.bb[1], bb[2]-p.boundingBox.bb[2], bb[3]-p.boundingBox.bb[3] };
        BoundingBox temp_bb = new BoundingBox(tab);
        return temp_bb;
    }

}
