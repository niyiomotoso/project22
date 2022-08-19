import java.util.Arrays;

public class LicenseKeyFormatting {
    public static void main (String [] args) {
        System.out.println(licenseKeyFormatting("aaaa", 2));
    }
    public static String licenseKeyFormatting (String s, int k) {
         s = s.replace("-", "");
         StringBuilder ss = new StringBuilder(s).reverse();
         StringBuilder finalC = new StringBuilder();
        char[] ssCharArray = ss.toString().toCharArray();
        int addedDashes = 0;


        for (int i=0; i< ssCharArray.length; i++) {
            char x = ssCharArray[i];
            finalC.append(x);
            if ((finalC.length() - addedDashes )%k == 0 && i != ssCharArray.length -1) {
                addedDashes++;
                finalC.append('-');
            }
        }


        return  (finalC.reverse().toString()).toUpperCase();
    }
}
