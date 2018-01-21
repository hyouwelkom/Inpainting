package td.inpainting;

import td.topology.*;

import java.util.Arrays;

public class InPainting {
    private static int tgv = Integer.MAX_VALUE;
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
                    image.val.get(newI).set(newJ, image.val.get(mi + i).get(mj + j));
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

    private Point best_match(Patch patch, BoundingBox Box) {

    }


    private void restore(int halfwidth, int searchWidth) {
        Boundary bd = new Boundary(m);
        Components co = new Components(bd);

        if (co.size()!=0){
            for(int i=0; i<co.components.size(); i++){
                BoundingBox bbox;
                if(!(searchWidth==0)){
                    bbox=searchingBox(component, )
                }
            }
        }
    }

    private BoundingBox searchingBox(Component component, int halfSizeBox) { return null; }