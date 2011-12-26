import java.util.HashMap;
public class p14 {
    public static int getCntSteps (long num) {
        int ans = 0;
        long now = num;
        while (! cntSteps.containsKey(now)) {
            ans += 1;
            if (now % 2 == 0) {
                now /= 2;
            } else {
                now = 3 * now + 1;
            }
        }
        ans += cntSteps.get(now);
        cntSteps.put(num, ans);
        return ans;
    }
    public static HashMap<Long, Integer> cntSteps = new HashMap<Long, Integer>();
    public static void main (String[] args) {
        int maxl = 0, maxi = 0, nowl;
        cntSteps.put(1L, 1);
        for (int i = 1; i < 1000000; ++i) {
            nowl = getCntSteps(i);
            if (nowl > maxl) {
                maxl = nowl;
                maxi = i;
            }
        }
        System.out.println(maxi);
    }
}
