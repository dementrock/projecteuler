import java.io.*;
import java.util.*;
public class p96 {
    public static final int MAXN = 9;
    public static final String inputFileStr = "../files/sudoku.txt";
    public static final int[][] grids = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
        {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
        {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
        {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
        {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
        {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
        {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
        {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
        {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
    };
    public static int[][] puzzle = new int[MAXN + 1][MAXN + 1];
    public static int[] usedRowCnt = new int[MAXN + 1];
    public static int[] usedColumnCnt = new int[MAXN + 1];
    public static int[] usedGridCnt = new int[MAXN + 1];
    public static boolean[][] usedRow = new boolean[MAXN + 1][MAXN + 1];
    public static boolean[][] usedColumn = new boolean[MAXN + 1][MAXN + 1];
    public static boolean[][] usedGrid = new boolean[MAXN + 1][MAXN + 1];
    public static BufferedReader fin;
    public static int sum = 0;
    public static void init() throws IOException, FileNotFoundException {
        File inputFile = new File(inputFileStr);
        FileReader inputFileReader = new FileReader(inputFile);
        fin = new BufferedReader(inputFileReader);
    }
    public static void input() throws IOException {
        fin.readLine();
        for (int i = 1; i <= MAXN; ++i) {
            String curLine = fin.readLine();
            for (int j = 1; j <= MAXN; ++j) {
                puzzle[i][j] = curLine.charAt(j - 1) - '0';
            }
        }
        /* Reset arrays */
        for (int i = 1; i <= MAXN; ++i) {
            usedRowCnt[i] = usedColumnCnt[i] = usedGridCnt[i] = 0;
            for (int j = 1; j <= MAXN; ++j) {
                usedRow[i][j] = usedColumn[i][j] = usedGrid[i][j] = false;
            }
        }
        /* Set initial used values */
        for (int i = 1; i <= MAXN; ++i) {
            for (int j = 1; j <= MAXN; ++j) {
                if (puzzle[i][j] != 0) {
                    int curGrid = grids[i][j];
                    usedRow[i][puzzle[i][j]] = usedColumn[j][puzzle[i][j]] = usedGrid[curGrid][puzzle[i][j]] = true;
                    ++usedRowCnt[i];
                    ++usedColumnCnt[j];
                    ++usedGridCnt[curGrid];
                }
            }
        }
    }
    public static boolean search (int nowx, int nowy) {
        if (nowx == MAXN && nowy == MAXN + 1) {
            sum += puzzle[1][1] * 100 + puzzle[1][2] * 10 + puzzle[1][3];
            return true;
        }
        if (nowy == MAXN + 1) {
            return search(nowx + 1, 1);
        }
        if (puzzle[nowx][nowy] != 0) {
            return search(nowx, nowy + 1);
        }
        if (usedRowCnt[nowx] == MAXN || usedColumnCnt[nowy] == MAXN || usedGridCnt[grids[nowx][nowy]] == MAXN) {
            return false;
        }
        int curGrid = grids[nowx][nowy];
        for (int i = 1; i <= 9; ++i) {
            if (!usedRow[nowx][i] && !usedColumn[nowy][i] && !usedGrid[curGrid][i]) {
                usedRow[nowx][i] = usedColumn[nowy][i] = usedGrid[curGrid][i] = true;
                ++usedRowCnt[nowx];
                ++usedColumnCnt[nowy];
                ++usedGridCnt[curGrid];
                puzzle[nowx][nowy] = i;
                if (search(nowx, nowy + 1)) {
                    return true;
                }
                puzzle[nowx][nowy] = 0;
                --usedColumnCnt[nowy];
                --usedRowCnt[nowx];
                --usedGridCnt[curGrid];
                usedRow[nowx][i] = usedColumn[nowy][i] = usedGrid[curGrid][i] = false;
            }
        }
        return false;
    }
    public static void main (String[] args) throws IOException {
        init();
        for (int i = 0; i < 50; ++i) {
            input();
            search(1, 1);
        }
        System.out.println(sum);
    }
}
