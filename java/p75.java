/* The general primitive solution to the equation x^2 + y^2 = z^2 with y even is
 * x = r^2 - s^2, y = 2rs, z = r^2 + s^2, where (r, s) = 1, 2 \nmid r + s
 */

public class p75 {
    public static final int MAX = 1500000;
    public static int[] cntSolution = new int [MAX + 1];
    public static int gcd (int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd (b % a, a);
        }
    }
    public static void main (String[] args) {
        int upplimit = (int) Math.sqrt(MAX);
        int ans = 0;
        for (int s = 1; s <= upplimit; ++s) {
            for (int r = s + 1; r <= upplimit; ++r) {
                if ( (r + s) % 2 == 1 && gcd(r, s) == 1) {
                    int sum = (r * r - s * s) + (2 * r * s) + (r * r + s * s);
                    for (int i = sum; i <= MAX; i += sum) {
                        ++cntSolution[i];
                    }
                }
            }
        }
        for (int i = 1; i <= MAX; ++i) {
            if (cntSolution[i] == 1) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
