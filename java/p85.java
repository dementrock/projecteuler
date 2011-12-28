public class p85 {
    public static final int MAX = 2000000;
    public static int tri (int num) {
        return num * (num + 1) / 2;
    }
    public static void main(String[] args) {
        int nearest = 0, area = 0;
        for (int i = 1; tri(i) < MAX; ++i) {
            for (int j = 1; tri(i) * tri(j) < MAX; ++j) {
                if (tri(i) * tri(j) > nearest) {
                    nearest = tri(i) * tri(j);
                    area = i * j;
                }
            }
        }
        System.out.println(area);
    }
}
