public class p2 {
    public static void main (String args[]) {
        int prev = 1, cur = 1, sum = 0, tmp;
        while (cur <= 4000000) {
            if (cur % 2 == 0) {
                sum += cur;
            }
            tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        System.out.println(sum);
    }
}
