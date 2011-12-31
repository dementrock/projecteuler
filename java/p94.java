/* As provided by the problem, such a triangle must have side lengths x, x, x +
 * 1 or x - 1, x, x. The corresponding area is
 * (x + 1) / 2 * sqrt(x ^ 2 - ((x + 1) / 2) ^ 2), and
 * (x - 1) / 2 * sqrt(x ^ 2 - ((x - 1) / 2) ^ 2).
 * It can be shown that x must therefore be odd.
 * Therefore, for the first formula, we must have sqrt(3x^2 - 2x - 1) is an
 * integer, and for the second formula, we must have sqrt(3x^2 + 2x - 1) is an
 * integer. Let m be the corresponding integer and solve for x:
 * For the first equation we have 3x^2 - 2x - 1 = m^2, so
 * x = (1 + sqrt(3m^2 + 4)) / 3,
 * For the second equation we have x = (-1 + sqrt(3m^2 + 4)) / 3.
 * So for either we must require that sqrt(3m^2 + 4) be an integer. Let it be
 * k. Then k^2 - 3m^2 = 4. Now if k were odd, then (+-1 + sqrt(3m^2 + 4)) / 3 = 
 * (+-1 + k) / 3 cannot be an integer. So k and m must both be even. But then
 * (k/2)^2 - 3(m/2)^2 = 1 is of the form of Pell's Equation, and can be solved
 * by continued fractions.
 */

import acm.PellSolver;
import java.math.BigInteger;

public class p94 {
    public static final long MAX = 1000000000L;
    public static boolean isInteger (double x) {
        //System.out.println(x);
        return Math.abs(x - ((long) x)) < 1e-5;
    }
    public static boolean satisfied (long a, long b, long c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && isInteger(c / 2.0 * Math.sqrt(a * a - (c * c / 4.0)));
    }
    public static void main (String[] args) {
        PellSolver solver = new PellSolver(3, 1);
        long ans = 0;
        while (true) {
            BigInteger[] solution = solver.getNext();
            long k = solution[0].longValue() * 2;
            long x, perimeter;
            if (k % 3 == 0) {
                continue;
            } else if (k % 3 == 1) {
                x = (k - 1) / 3;
                if (!satisfied(x, x, x - 1)) {
                    continue;
                }
                perimeter = 3 * x - 1;
            } else {
                x = (k + 1) / 3;
                if (!satisfied(x, x, x + 1)) {
                    continue;
                }
                perimeter = 3 * x + 1;
            }
            if (perimeter > MAX) {
                break;
            }
            ans += perimeter;
        }
        System.out.println(ans);
    }
}
