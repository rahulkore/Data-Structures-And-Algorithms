package misc;

public class Msb {
    static int setBitNumber(int n)
    {
        // To find the position of the
        // most significant set bit
        int k = (int)(Math.log(n) / Math.log(2));
 
        // To return the the value of the number
        // with set bit at k-th position
        return 1 << k;
    }
    public static void main(String[] args) {
        
    }
    
}
