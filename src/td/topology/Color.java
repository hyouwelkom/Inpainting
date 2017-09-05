package topology;

public class Color {
    public static int dist (Color c1, Color c2) { return 0; }

    // Definition of the color in BGR format 3x8bits val=[B,G,R] B,G,R = 8bits (Blue,Green,Red)
    public byte[] val;

    public Color(byte B, byte G, byte R) {}
    public Color(int B, int G, int R) {}

    // Noice the name all in lowercase..
    public boolean isequalto(Color color) { return false; }
    public void set(Color color) {}

    @Override
    public String toString() { return ""; }
}
