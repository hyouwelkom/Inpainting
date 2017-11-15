package td.topology;

import java.io.IOException;

public class Mask extends BoundingBox {
    public boolean[][] val;

    public Mask(Matrix matrix, Color color) {
        super(matrix);
        val = new boolean[width][height];
        int k = 0;
        for ( int j = 0; j < height; j++ )
            for ( int i = 0; i < width; i++ )
                val[i][j] = matrix.val[i][j].isequalto(color);
    }

    public Mask(String fileName, Color color) throws IOException {
        this(new Matrix(fileName), color);
    }

    public boolean touchedBy(Point point) {
        int i = point.i;
        int j = point.j;
        boolean res = false;
        for ( int I = Math.max(i - 1, 0); I < Math.min(i + 1, width); I++ )
            for ( int J = Math.max(j - 1, 0); J < Math.min(j + 1, height); J++ )
                res = res || val[I][J];
        return res;
    }
}
