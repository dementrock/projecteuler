public class p68 {
    public static int[] nodeList = new int[11];
    public static boolean[] used = new boolean[11];
    public static int[] checkList = {
        -1, -1, -1, -1, 0, -1, 1, -1, 2, -1, 3, 4,
    };
    public static int[][] rings = {
        {1, 2, 3},
        {4, 3, 5},
        {6, 5, 7},
        {8, 7, 9},
        {10, 9, 2},
    };
    public static String maxStr = "";
    public static void search (int depth) {
        if (checkList[depth] >= 0) {
            int index = checkList[depth];
            int x = rings[index][0], y = rings[index][1], z = rings[index][2];
            if (nodeList[x] + nodeList[y] + nodeList[z] != nodeList[1] + nodeList[2] + nodeList[3]) {
                return;
            }
        }
        if (depth == 11) {
            int minExternal = 999, minIndex = 0;
            for (int i = 0; i < 5; ++i) {
                if (nodeList[rings[i][0]] < minExternal) {
                    minExternal = nodeList[rings[i][0]];
                    minIndex = i;
                }
            }
            String str = "";
            for (int times = 0, i = minIndex; times < 5; ++times, i = (i + 1) % 5) {
                for (int j = 0; j < 3; ++j) {
                    str += Integer.toString(nodeList[rings[i][j]]);
                }
            }
            if (str.length() == 16) {
                if (str.compareTo(maxStr) > 0 || maxStr == "") {
                    maxStr = str;
                }
            }
            return;
        }
        for (int i = 1; i <= 10; ++i) {
            if (!used[i]) {
                nodeList[depth] = i;
                used[i] = true;
                search(depth + 1);
                used[i] = false;
                nodeList[depth] = 0;
            }
        }
    }
    public static void main (String[] args) {
        search(1);
        System.out.println(maxStr);
    }
}
