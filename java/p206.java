import java.util.regex.Pattern;

public class p206 {
    public static void main (String[] args) {
        for (long i = 101010101; i <= 138902662; ++i) {
            if (i % 10 == 3 || i % 10 == 7) {
                if (Pattern.matches("1.2.3.4.5.6.7.8.9", Long.toString(i * i))) {
                    System.out.println(i * 10);
                    break;
                }
            }
        }
    }
}
