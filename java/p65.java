import java.math.BigInteger;
public class p65 {
    public static int getAt (int index) {
        if (index == 0) {
            return 2;
        } else if (index % 3 != 2) {
            return 1;
        } else {
            return (index + 1) / 3 * 2;
        }
    }
    public static BigInteger[] p = new BigInteger[110];
    public static void main (String[] args) {
        p[0] = new BigInteger("0");
        p[1] = new BigInteger("1");
        for (int i = 2; i <= 101; ++i) {
            p[i] = p[i - 1].multiply(new BigInteger(Integer.toString(getAt(i - 2)))).add(p[i - 2]);
        }
        int ans = 0;
        String str = p[101].toString();
        for (int i = 0; i < str.length(); ++i) {
            ans += (int) str.charAt(i) - '0';
        }
        System.out.println(ans);
    }
}
