import java.net.*;
import java.io.*;
import java.util.*;

public class p82 {
    public static final String url_str = "http://projecteuler.net/project/matrix.txt";
    public static final int INFINITY = 10000000;
    public static int[][] map;
    public static int[][] f;
    public static int n;
    public static void init() throws IOException {
        n = 80;
        map = new int[n][n];
        f = new int[n][n];
        URL url = new URL(url_str);
        InputStream in = url.openStream();
        Scanner sc = new Scanner(in);
        for (int i = 0; i < n; ++i) {
            String curLine = sc.next();
            String[] numList = curLine.split(",");
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(numList[j]);
                f[i][j] = INFINITY;
            }
        }
        in.close();
    }
    public static int getf (int x, int y) {
        if (x >= 0 && y >= 0 && x <n && y < n) {
            return f[x][y];
        } else if (y < 0) {
            return 0;
        } else {
            return INFINITY;
        }
    }
    public static void dp_down() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = Math.min(f[i][j], getf(i - 1, j) + map[i][j]);
                f[i][j] = Math.min(f[i][j], getf(i, j - 1) + map[i][j]);
            }
        }
    }
    public static void dp_up() {
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = Math.min(f[i][j], getf(i + 1, j) + map[i][j]);
                f[i][j] = Math.min(f[i][j], getf(i, j - 1) + map[i][j]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; ++i) {
            dp_down();
            dp_up();
        }
        int ans = INFINITY;
        for (int i = 0; i < n; ++i) {
            if (f[i][n - 1] < ans) {
                ans = f[i][n - 1];
            }
        }
        System.out.println(ans);
    }
}
