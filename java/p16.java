import java.math.BigInteger;
public class p16 {
    public static void main (String[] args) {
        BigInteger ans = new BigInteger("2").pow(1000);
        String strAns = ans.toString();
        int sumDigits = 0;
        for (int i = 0; i < strAns.length(); ++i) {
            sumDigits += (int) strAns.charAt(i) - '0';
        }
        System.out.println(sumDigits);
    }
}
