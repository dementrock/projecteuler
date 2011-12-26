public class p9 {
    public static void main (String args[]) {
        for (int a = 1; a <= 1000; ++a) {
            for (int b = a + 1; b <= 1000; ++b) {
                int c = 1000 - a - b;
                if (c <= b) {
                    break;
                }
                if (a * a + b * b == c * c) {
                    System.out.println(a * b * c);
                }
            }
        }
    }
}
