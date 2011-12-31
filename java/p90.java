import java.util.Arrays;
public class p90 {
    public static int[][] arrangeList = new int[300][10];
    public static int cntList = 0;
    public static int[] curList = new int[10];
    public static boolean[] convert (int[] curList) {
        boolean[] used = new boolean[10];
        Arrays.fill(used, false);
        for (int i = 0; i < 6; ++i) {
            used[curList[i]] = true;
            if (curList[i] == 6 || curList[i] == 9) {
                used[6] = used[9] = true;
            }
        }
        return used;
    }
    public static void genList (int depth, int last) {
        if (depth == 7) {
            for (int i = 0; i < 6; ++i) {
                arrangeList[cntList][i] = curList[i + 1];
            }
            ++cntList;
        } else {
            for (int i = last + 1, tmp = last; i <= 9; ++i) {
                curList[depth] = i;
                genList(depth + 1, i);
                curList[depth] = 0;
            }
        }
    }
    public static boolean isSatisfied (boolean[] used1, boolean[] used2) {
        for (int i = 1; i <= 9; ++i) {
            int sqr = i * i;
            if (!(used1[sqr / 10] && used2[sqr % 10] || used1[sqr % 10] && used2[sqr / 10])) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        int cnt = 0;
        genList(1, -1);
        for (int i = 0; i < cntList; ++i) {
            for (int j = 0; j < cntList; ++j) {
                if (isSatisfied(convert(arrangeList[i]), convert(arrangeList[j]))) {
                    ++cnt;
                }
            }
        }
        System.out.println(cnt / 2);
    }
}
