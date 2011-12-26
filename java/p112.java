public class p112 {
    public static boolean isIncreasing (int num) {
        String str = Integer.toString(num);
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i + 1) < str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isDecreasing (int num) {
        String str = Integer.toString(num);
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i + 1) > str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isBouncy (int num) {
        return !isIncreasing(num) && !isDecreasing(num);
    }
    public static void main (String[] args) {
        int cntBouncy = 0;
        for (int i = 1; ; ++i) {
            if (isBouncy(i)) {
                ++cntBouncy;
            }
            if (1.0 * cntBouncy / i >= 0.99) {
                System.out.println(i);
                break;
            }
        }
    }
}
