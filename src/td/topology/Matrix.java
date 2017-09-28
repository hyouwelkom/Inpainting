package td.topology;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Matrix extends BoundingBox {

    public Color[][] val;

    public Matrix(String fileName) throws IOException {
        super();
        Matrix matrix = new Matrix(fileName);
        BufferedImage bimg = ImageIO.read(new File(fileName));
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        matrix.width = width;
        matrix.height = height;
    }

    public void applyMask(Mask mask) {
        Mask _mask = new Mask();
    }

    public void save(String fileName) throws IOException {
        BufferedImage matrix = ImageIO.read(new File(fileName));
        ImageIO.write(matrix, "BMP", new File(fileName + ".bmp"));
    }
}
