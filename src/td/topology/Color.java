package td.topology;

public class Color {

    // Definition of the color in BGR format 3x8bits val=[B,G,R] B,G,R = 8bits (Blue,Green,Red)
    private byte[] val;

    public Color(byte B, byte G, byte R) {
        val[0] = B;
        val[1] = G;
        val[2] = R;
    }

    //Cast int entry into byte
    public Color(int B, int G, int R) {
        val[0] = ((byte) B);
        val[1] = ((byte) G);
        val[2] = ((byte) R);
    }

    //Return difference between two color
    public static int dist (Color c1, Color c2) {
        int dist = 0;
        dist = ((c1.val[0] - c2.val[0])*(c1.val[0] - c2.val[0]))+((c1.val[1] - c2.val[1])*(c1.val[1] - c2.val[1]))+((c1.val[2] - c2.val[2])*(c1.val[2] - c2.val[2]));
        return dist;
    }


    // Noice the name all in lowercase..
    public boolean isequalto(Color color) {
        if (this.val[0] == color.val[0] ) {
            if (this.val[1] == color.val[1] ) {
                if (this.val[2] == color.val[2] ) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    public void set(Color color) {
        val[0] = color.val[0];
        val[1] = color.val[1];
        val[2] = color.val[2];
    }

//    public Color get(int i){
//        return val[i];
//    }

    @Override
    public String toString() { return "[B,G,R] = ["+val[0]+","+val[1]+","+val[2]+"]"; }
}
