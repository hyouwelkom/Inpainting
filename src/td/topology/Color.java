package td.topology;

public class Color {
    private byte B;
    private byte G;
    private byte R;
    // Use the BGR color format
    // Definition of the color in BGR format 3x8bits val=[B,G,R] B,G,R = 8bits (Blue,Green,Red)
    private byte[] val;


    public Color(byte B, byte G, byte R) {
        val[0] = B;
        val[1] = G;
        val[2] = R;
    }

    public Color(int B, int G, int R) {
        val[0] = ((byte) B);
        val[1] = ((byte) G);
        val[2] = ((byte) R);
    }



    public static int dist (Color c1, Color c2) {
        return 0;
    }





    // Noice the name all in lowercase..
    public boolean isequalto(Color color) { return false;}

    public void set(Color color) {}

    @Override
    public String toString() { return ""; }
}
