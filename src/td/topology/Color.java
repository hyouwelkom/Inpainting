package td.topology;

public class Color {
    private byte B;
    private byte G;
    private byte R;
    // Use the BGR color format


    public Color(byte B, byte G, byte R) {this.B = B; this.G = G; this.R = R;}

    // Check if int <= 255; If not, variable = null;
    public Color(int B, int G, int R) {
        if ( B <= 255 )
            this.B = B;
        else this.B = null;

        if ( G <= 255 )
            this.G = G;
        else this.G = null;

        if ( R <= 255 )
            this.R = R;
        else this.R = null;
    }



    public static int dist (Color c1, Color c2) {

    }

    // Definition of the color in BGR format 3x8bits val=[B,G,R] B,G,R = 8bits (Blue,Green,Red)
    public byte[] val;



    // Noice the name all in lowercase..
    public boolean isequalto(Color color) {
        if (this.B == color.B) {
            if (this.G == color.G) {
                if (this.R == color.R){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }

    public void set(Color color) {}

    @Override
    public String toString() { return ""; }
}
