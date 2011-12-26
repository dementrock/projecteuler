public class p4 {
    public static boolean isPalindrome (int num) {
        String str = Integer.toString(num);
        return str.equals(new StringBuffer(str).reverse().toString());
    }
    public static void main (String args[]) {
        int ans = 0;
        for (int i = 100; i <= 999; ++i) {
            for (int j = 100; j <= 999; ++j) {
                if (isPalindrome(i * j)) {
                    ans = Math.max(ans, i * j);
                }
            }
        }
        System.out.println(ans);
    }
}
