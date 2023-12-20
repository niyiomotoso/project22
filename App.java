import java.math.BigInteger;

public class App {
    public static void main(String [] args) {
        // System.out.println(meth(2479, 2));
        System.out.println(48%7);
    }

    public static int meth(int a, int b) {
        BigInteger result = new BigInteger(String.valueOf(a)).multiply(new BigInteger(String.valueOf(b)));
        int totalOnes = 0;
        String resultInBinaryString = result.toString(2);

        for (int i = 0; i <resultInBinaryString.length(); i++) {
            if (String.valueOf(resultInBinaryString.charAt(i)).equals(String.valueOf(1)) ){
                totalOnes++;
            }
        }

        return  totalOnes;
    }
}
