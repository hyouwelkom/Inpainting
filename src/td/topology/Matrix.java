package td.topology;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.black;

public class Matrix extends BoundingBox {

    public Color[][] val;

    public Matrix(String fileName) throws IOException {
        super(fileName);
        Matrix matrix = new Matrix(fileName);
        BufferedImage bimg = ImageIO.read(new File(fileName));
        byte[] pixels = ((DataBufferByte) bimg.getRaster().getDataBuffer()).getData();
        val = new Color[width][height];
        int k = 0;
        for ( int j = 0; j < height; j++ ) {
            for ( int i = 0; i < width; i++ ) {
                byte r = pixels[k++];
                byte g = pixels[k++];
                byte b = pixels[k++];
                val[i][j] = new Color(r, g, b);
            }
        }
    }

    public void applyMask(Mask mask) throws IOException {
        this(new Matrix((Matrix) mask, black);
    }

    public void save(String fileName) throws IOException {
        BufferedImage matrix = ImageIO.read(new File(fileName));
        ImageIO.write(matrix, "BMP", new File(fileName + ".bmp"));
    }
}
