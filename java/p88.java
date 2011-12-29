/* Let the minimal product-number for k be f(k).
 * First, note that since all numbers are greater than or equal to 1, we must
 * have f(k) >= k. Second, since 2 * k * 1 * 1 * ... * 1 = 2 * k + 1 + 1 + ... + 1, with
 * (k - 2) ones on both sides, we must have f(k) <= 2k. So we only need to
 * search numbers up to 24000.
 *
 * NOTE: There exists i, j such that i < j but f(i) > f(j)!
 */

import java.util.Arrays;

public class p88 {
    public static final int MAXPRIME = 24000;
    public static final int MAXK = 12000;
    public static final int MAXFACTOR = 15;
    public static int[] f = new int[MAXK + 1];
    public static void searchFactors (int[] numList, int cntNums, int num, int restNum, int sumFactors) {
        if (restNum == 1) {
            int k = cntNums + num - sumFactors;
            if (k <= MAXK && f[k] == 0) {
                f[k] = num;
            }
        } else {
            int start = (cntNums == 0 ? 2 : numList[cntNums - 1]);
            for (int i = start; i <= restNum && i < num; ++i) {
                if (restNum % i == 0 && sumFactors + i <= num) {
                    numList[cntNums] = i;
                    searchFactors(numList, cntNums + 1, num, restNum / i, sumFactors + i);
                    numList[cntNums] = 0;
                }
            }
        }
    }
    public static void update (int num) {
        searchFactors(new int[MAXFACTOR], 0, num, num, 0);
    }
    public static void main(String[] args) {
        for (int i = 2; i <= MAXK * 2; ++i) {
            update(i);
        }
        long ans = 0;
        Arrays.sort(f);
        for (int i = 2; i <= MAXK; ++i) {
            if (f[i] != f[i - 1]) {
                ans += f[i];
            }
        }
        System.out.println(ans);
    }
}
