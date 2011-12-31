import java.io.*;
import java.util.*;
public class p98 {
    public static final String inputFileStr = "../files/words.txt";
    public static BufferedReader fin;
    public static String[] nameList;
    public static int ans = 0;
    public static void init() throws IOException, FileNotFoundException {
        File inputFile = new File(inputFileStr);
        FileReader inputFileReader = new FileReader(inputFile);
        fin = new BufferedReader(inputFileReader);
    }
    public static void input() throws IOException {
        String nameListStr = fin.readLine();
        nameList = nameListStr.substring(1, nameListStr.length() - 1).split("\",\"");
    }
    public static char[] toArray (String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            res[i] = s.charAt(i);
        }
        return res;
    }
    public static boolean isAnagram (String s1, String s2) {
        char[] c1 = toArray(s1), c2 = toArray(s2);
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
    public static boolean isSquare (int x) {
        return x > 0 && x == ((int)Math.sqrt(x)) * ((int)Math.sqrt(x));
    }
    public static int getNum (String s, int[] match) {
        int num = 0;
        if (match[s.charAt(0) - 'A'] == 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); ++i) {
            num = num * 10 + match[s.charAt(i) - 'A'];
        }
        return num;
    }
    public static boolean isMatchSquare (String s, int[] match) {
        return isSquare(getNum(s, match));
    }
    public static void search (int curDepth, int maxDepth, int[] sub, boolean[] used, char[] charList, String s1, String s2) {
        if (curDepth == maxDepth) {
            int[] match = new int[30];
            for (int i = 0; i < maxDepth; ++i) {
                match[charList[i] - 'A'] = sub[i];
            }
            if (isMatchSquare(s1, match) && isMatchSquare(s2, match)) {
                ans = Math.max(ans, getNum(s1, match));
                ans = Math.max(ans, getNum(s2, match));
            }
        } else {
            for (int i = 0; i <= 9; ++i) {
                if (!used[i]) {
                    used[i] = true;
                    sub[curDepth] = i;
                    search(curDepth + 1, maxDepth, sub, used, charList, s1, s2);
                    sub[curDepth] = 0;
                    used[i] = false;
                }
            }
        }
    }
    public static void check (String s1, String s2) {
        if (!isAnagram(s1, s2)) {
            return;
        }
        char[] c1 = toArray(s1);
        Arrays.sort(c1);
        char[] charList = new char[c1.length];
        int cntChar = 0;
        charList[cntChar++] = c1[0];
        for (int i = 1; i < c1.length; ++i) {
            if (charList[i] != charList[i - 1]) {
                charList[cntChar++] = c1[i];
            }
        }
        int[] sub = new int[cntChar];
        boolean[] used = new boolean[10];
        Arrays.fill(sub, 0);
        Arrays.fill(used, false);
        search(0, cntChar, sub, used, charList, s1, s2);
    }
    public static void main (String[] args) throws IOException {
        init();
        input();
        int cnt = 0;
        for (int i = 0; i < nameList.length; ++i) {
            for (int j = i + 1; j < nameList.length; ++j) {
                check(nameList[i], nameList[j]);
            }
        }
        System.out.println(ans);
    }
}
