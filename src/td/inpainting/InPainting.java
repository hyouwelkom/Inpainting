package td.inpainting;

import td.topology.*;

public class InPainting {
    private static int tgv = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    private Matrix image;
    private Mask m;
    private int[][] penMask;
    private BoundingBox window;

    public InPainting(Matrix _image, Mask _m) {}
    private int[] argmin(double[][] array) { return null; }
    private Point best_match(Patch patch, BoundingBox Box) { return null; }
    private void copyPatch(Point best_point, Patch patch) {}
    private void restore(int halfwidth, int searchWidth) {}
    private BoundingBox searchingBox(Component component, int halfSizeBox) { return null; }
}
