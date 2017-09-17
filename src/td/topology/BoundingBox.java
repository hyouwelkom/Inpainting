package td.topology;

public class BoundingBox {
    public int[] bb;
    public int width, height, size;

    int nbEdgesHorizontal, nbEdgesVertical, nbEdges;

    public BoundingBox() {}
    public BoundingBox(BoundingBox boundingBox) {
        this.width = boundingBox.width;
        this.height = boundingBox.height;
        this.size = boundingBox.size;
        this.bb = boundingBox.bb;
    }

    public BoundingBox(java.awt.image.BufferedImage image) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.size = this.height*this.width;
    }
    public BoundingBox(int[] bb_) {
        this.width = bb[2]-bb[0];
        this.height = bb[3]-bb[1];
        this.bb = bb_;
        this.size= this.height*this.width;
    }
    public BoundingBox(java.lang.String fileName) {
        try
        {
           BufferedImage img = ImageIO.read(new File(fileName));
            this.width = img.getWidth();
            this.height = img.getHeight();
            this.size = this.width*this.height;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public BoundingBox crop(Patch patch) { //Il reste ça ç faire

        return this;


    }
}
