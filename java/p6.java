public class p6 {
    public static void main (String args[]) {
        int sum_sqr = 0, sum = 0;
        for (int i = 1; i <= 100; ++i) {
            sum_sqr += i * i;
            sum += i;
        }
        System.out.println(sum * sum - sum_sqr);
    }
}
