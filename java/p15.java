import java.util.HashMap;
import java.util.Arrays;
public class p15 {
    public static long getCntRoutes (int x, int y) {
        if (isCalculated[x][y]) {
            return cntRoutes[x][y];
        } else {
            isCalculated[x][y] = true;
            if (x == 0 || y == 0) {
                return cntRoutes[x][y] = 1;
            } else {
                return cntRoutes[x][y] = getCntRoutes(x - 1, y) + getCntRoutes(x, y - 1);
            }
        }
    }
    public static long [][] cntRoutes = new long[30][30];
    public static boolean [][] isCalculated = new boolean[30][30];
    public static void main (String[] args) {
        System.out.println(getCntRoutes(20, 20));
    }
}
