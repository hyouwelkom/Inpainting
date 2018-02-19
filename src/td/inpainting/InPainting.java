package td.inpainting;

import td.topology.*;

import java.io.IOException;
import java.util.Arrays;

public class InPainting {
    private static int tgv = 3*255*255+1;
    private Matrix image;
    private Mask m;
    private int[][] penMask;
    private BoundingBox window;

    public InPainting(Matrix _image, Mask _m) {
        this.image = _image;
        this.m = _m;

        if (Arrays.equals(image.getBb(), m.getBb())) {
            window = image;
        }

        final int w = image.getWidth();
        final int h = image.getHeight();
        penMask = new int[w][h];


        for (int i = 0; i < (w - 1); ++i) {
            for (int j = 0; j < (h - 1); ++j) {
                penMask[i][j] = m.val[i][j] ? tgv : 0;
            }
        }
    }

    public static void main(String[] args) {
    }

    private void copyPatch(Point best_point, Patch patch) {
        int mi = best_point.i;
        int mj = best_point.j;

        for (int i = patch.boundingBox.getBb()[0]
             ; i < mi; ++i) {
            for (int j = patch.boundingBox.getBb()[1]
                 ; j < mj; ++j) {
                int newI = patch.point.i + i;
                int newJ = patch.point.j + j;

                if (m.val[newI][newJ]) {
                    image.val[newI][newJ].set(image.val[mi+i][mj+j]);
                }
                m.val[newI][newJ] = false;
            }
        }
    }

    private int[] argmin(double[][] array) {
        int i = 0;
        int j = 0;
        int tmpi, tmpj;
        double[][] minarray = new double[0][];
        int[] minarg = new int[0];
        for (double[] d : array) {
            if (minarray[i][j] < array[i][j]) {
                tmpi = i;
                tmpj = j;
                minarg[0] = tmpi;
                minarg[1] = tmpj;
            } else {
                i++;
                j++;
            }
        }
        return minarg;
    }

    private Point best_match(Patch p,BoundingBox Box){
        if(Box == null) {
            Box = new BoundingBox(new int[]{0,0,m.getWidth(),m.getWidth()});
        }

        BoundingBox sBox = Box.crop(p);

        double[][] norme = new double[sBox.getWidth()][sBox.getHeight()];

        for(int i = 0;i < sBox.getWidth(); i++) {
            for(int j = 0; j < sBox.getHeight(); j++){
                norme[i][j]=0;
            }
        }

        for(int x = p.boundingBox.getBB(0); x < p.boundingBox.getBB(2); x++)
        {
            for(int y = p.boundingBox.getBB(1); y < p.boundingBox.getBB(3); y++)
            {
                int xmin = sBox.getBB(0) + x;
                int xmax = sBox.getBB(2) + x;
                int ymin = sBox.getBB(1) + y;
                int ymax = sBox.getBB(3) + y;
                int X = p.point.i + x;
                int Y = p.point.j + y;

                for(int i = 0; i < sBox.getWidth(); i++){
                    for(int j = 0; j < sBox.getHeight(); j++) {
                        norme[i][j]+=penMask[xmin+i][ymin+j];
                    }

                }
                if (!m.val[X][Y]) {
                    for (int k = 0; k < sBox.getWidth(); k++)
                        for (int l = 0; l < sBox.getHeight(); l++)
                            norme[k][l] += Color.dist(image.val[xmin + k][ymin + l], image.val[X][Y]);
                }
            }
        }
        int[] index = argmin(norme);
        return new Point(m,index[0] + sBox.getBB(0),index[1] + sBox.getBB(1));
    }


    private void restore(int halfwidth, int searchWidth) throws IOException {
        Boundary bd = new Boundary(m);
        Components co = new Components(bd);
        Point p;
        Component c;
        if (co.size()!=0){
            for(int i=0; i<co.components.size(); i++){
                c=(Component)co.components.get(i);
                BoundingBox bbox;
                if(!(searchWidth==0)){
                    bbox=searchingBox(c,searchWidth);
                for(Point p: c.points){
                    if ((m.touchedBy(p))){
                        Patch patch=new Patch(p,halfwidth,window);
                        Point po=best_match(patch,bbox);
                        copyPatch(po,patch);
                        }
                    }
                }
            }
            bd=new Boundary(m);
            co=new Components(bd);
            if(searchWidth!=0){
                searchWidth+=halfwidth;
            }
            System.out.println("finished");
        }
    }

    private BoundingBox searchingBox(Component component, int marge) {
        Point p = component.points.get(0);
        int[] boundingbox = new int[] {p.i, p.j, p.i, p.j};
        for (Point point : component.getPoints()) {
            boundingbox[0] = Math.min(boundingbox[0], p.i);
            boundingbox[1] = Math.min(boundingbox[1], p.j);
            boundingbox[2] = Math.min(boundingbox[2], p.i);
            boundingbox[3] = Math.min(boundingbox[3], p.j);
        }

        int[] temp = new int[]{Math.max(boundingbox[0] - marge, 0), Math.max(boundingbox[1] - marge, 0), Math.max(boundingbox[2] + marge, window.getWidth()), Math.min(boundingbox[3] + marge, window.getHeight())};
        return new BoundingBox(temp);
    }

}