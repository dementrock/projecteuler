public class p91 {
    public static boolean isRightTriangle (int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x1 == x2 && y1 == y2 || x1 == x3 && y1 == y3) {
            return false;
        } else {
            return (x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0;
        }
    }
    public static final int MAXN = 50;
    public static void main (String[] args) {
        int cnt = 0;
        for (int x1 = 0; x1 <= MAXN; ++x1) {
            for (int y1 = 0; y1 <= MAXN; ++y1) {
                for (int x2 = 0; x2 <= MAXN; ++x2) {
                    for (int y2 = 0; y2 <= MAXN; ++y2) {
                        if (isRightTriangle(0, 0, x1, y1, x2, y2) || isRightTriangle(x1, y1, 0, 0, x2, y2) || isRightTriangle(x2, y2, 0, 0, x1, y1)) {
                            ++cnt;
                        }
                    }
                }
            }
        }
        System.out.println(cnt / 2);
    }
}
