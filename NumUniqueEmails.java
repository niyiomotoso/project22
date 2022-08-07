import java.util.ArrayList;

public class NumUniqueEmails {
    public static void main(String[] args) {
        String[] nff = new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(nff));
    }

    public static int numUniqueEmails(String[] emails) {
        ArrayList<String> uniq = new ArrayList<>();
        for (String s : emails) {
            StringBuilder email = new StringBuilder(s);
            int intEmailBeforeAt = email.lastIndexOf("@");
            String emailBeforeAt = email.substring(0, intEmailBeforeAt);
            String emailAfterAt = email.substring(intEmailBeforeAt);
            StringBuilder emailBeforeAtSB = new StringBuilder(emailBeforeAt);

            emailBeforeAtSB = new StringBuilder(emailBeforeAtSB.toString().replace(".", ""));

            int plusIndex = emailBeforeAtSB.indexOf("+");
            if(plusIndex >= 0){
                emailBeforeAtSB= new StringBuilder(emailBeforeAtSB.substring(0, plusIndex));
            }

            System.out.println(emailAfterAt);
            String finalResult = emailBeforeAtSB + emailAfterAt;
            if (!uniq.contains(finalResult)) {
                uniq.add(finalResult);
            }
        }
        System.out.println(uniq);
        return uniq.size();
    }

}
