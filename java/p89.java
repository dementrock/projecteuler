import java.io.*;
import java.util.*;
public class p89 {
    public static final String[][] minStr = {
        {"", "I","II","III","IV","V","VI","VII","VIII","IX"},
        {"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        {"", "M","MM","MMM","MMMM","MMMMM","MMMMMM","MMMMMMM","MMMMMMMM","MMMMMMMMM"},
    };
    public static final String symbols = "IVXLCDM";
    public static final String inputFileStr = "../files/roman.txt";
    public static final int[] values = {1, 5, 10, 50, 100, 500, 1000};
    public static BufferedReader fin;
    public static int getLocation(char x) {
        for (int i = 0; i < symbols.length(); ++i) {
            if (symbols.charAt(i) == x) {
                return i;
            }
        }
        return -1;
    }
    public static int getValue (char x) {
        return values[getLocation(x)];
    }
    public static int cmpSymbol (char a, char b) {
        return getLocation(a) - getLocation(b);
    }
    public static String getMinStr (int num) {
        return minStr[3][num / 1000] + minStr[2][(num % 1000) / 100] + minStr[1][(num % 100) / 10] + minStr[0][num % 10];
    }
    public static String[] separate (String str) {
        String[] symbolList = new String[30];
        int cntSymbol = 0;
        for (int i = 0; i < str.length(); ) {
            if (i == str.length() - 1) {
                symbolList[cntSymbol++] = str.substring(i);
                break;
            }
            if (cmpSymbol(str.charAt(i), str.charAt(i + 1)) < 0) {
                symbolList[cntSymbol++] = str.substring(i, i + 2);
                i += 2;
            } else {
                symbolList[cntSymbol++] = str.substring(i, i + 1);
                ++i;
            }
        }
        return symbolList;
    }
    public static int calcValue(String str) {
        if (str.length() == 1) {
            return getValue(str.charAt(0));
        } else {
            return getValue(str.charAt(1)) - getValue(str.charAt(0));
        }
    }
    public static int getNum (String str) {
        int num = 0;
        String[] symbolList = separate(str);
        for (int i = 0; symbolList[i] != null; ++i) {
            num += calcValue(symbolList[i]);
        }
        return num;
    }
    public static void init() throws IOException, FileNotFoundException {
        File inputFile = new File(inputFileStr);
        FileReader inputFileReader = new FileReader(inputFile);
        fin = new BufferedReader(inputFileReader);
    }
    public static void main (String[] args) throws IOException {
        int ans = 0;
        init();
        for (int i = 0; i < 1000; ++i) {
            String s = fin.readLine();
            ans += s.length() - getMinStr(getNum(s)).length();
        }
        System.out.println(ans);
    }
}
