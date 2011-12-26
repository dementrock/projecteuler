public class p74 {
    public static final int fac[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public static final int MAX = 3000000;
    public static boolean[] impossible = new boolean[MAX + 1];
    public static int getNext (int x) {
        String str = Integer.toString(x);
        int res = 0;
        for (int i = 0; i < str.length(); ++i) {
            res += fac[str.charAt(i) - '0'];
        }
        return res;
    }
    public static boolean isSatisfied (int x) {
        if (impossible[x]) {
            return false;
        }
        int[] numList = new int[100];
        int cntNum = 0;
        while (true) {
            boolean isRepeated = false;
            for (int i = 0; i < cntNum; ++i) {
                if (numList[i] == x) {
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated) {
                if (cntNum < 60) {
                    for (int i = 0; i < cntNum; ++i) {
                        impossible[numList[i]] = true;
                    }
                    return false;
                } else if (cntNum == 60) {
                    return true;
                } else {
                    return false;
                }
            }
            numList[cntNum++] = x;
            x = getNext(x);
        }
    }
    public static void main (String[] args) {
        int ans = 0;
        for (int i = 1; i < 1000000; ++i) {
            if (isSatisfied(i)) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
