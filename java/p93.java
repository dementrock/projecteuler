import java.util.Arrays;
public class p93 {
    public static boolean[] calculated = new boolean[10000];
    public static int maxCont = 0, ans;
    public static double calc (double a, double b, int opt) {
        if (opt == 0) {
            return a + b;
        } else if (opt == 1) {
            return a - b;
        } else if (opt == 2) {
            return a * b;
        } else if (opt == 3) {
            return a / b;
        }
        return 0;
    }
    public static boolean isInteger (double num) {
        return Math.abs(num - ((int) num)) < 1e-10;
    }
    public static void recordAnswer(double num) {
        if (isInteger(num) && num >= 1) {
            calculated[(int)num] = true;
        }
    }
    public static void checkSorted(int a, int b, int c, int d) {
        for (int opt1 = 0; opt1 < 4; ++opt1) {
            for (int opt2 = 0; opt2 < 4; ++opt2) {
                for (int opt3 = 0; opt3 < 4; ++opt3) {
                    recordAnswer(calc(calc(a, b, opt1), calc(c, d, opt2), opt3));
                    recordAnswer(calc(calc(calc(a, b, opt1), c, opt2), d, opt3));
                }
            }
        }
    }
    public static void check (int a, int b, int c, int d) {
        int[] digitList = {a, b, c, d};
        Arrays.fill(calculated, false);
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) if (i != j) {
                for (int k = 0; k < 4; ++k) if (k != i && k != j) {
                    for (int l = 0; l < 4; ++l) if (l != i && l != j && l != k) {
                        checkSorted(digitList[i], digitList[j], digitList[k], digitList[l]);
                    }
                }
            }
        }
        int cont = 0;
        while (true) {
            if (!calculated[++cont]) {
                --cont;
                break;
            }
        }
        if (cont > maxCont) {
            maxCont = cont;
            ans = a * 1000 + b * 100 + c * 10 + d;
        }
    }
    public static void main (String[] args) {
        for (int i = 1; i <= 9; ++i) {
            for (int j = i + 1; j <= 9; ++j) {
                for (int k = j + 1; k <= 9; ++k) {
                    for (int l = k + 1; l <= 9; ++l) {
                        check(i, j, k, l);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
