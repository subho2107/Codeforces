import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreasureHunt {
    public static int updateFreq(String a) {
        int [] freq = new int[52];
        for (char ch : a.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                freq[ch - 'a']++;
            else
                freq[26 + (ch - 'A')]++;
        }
        Arrays.sort(freq);
        return freq[freq.length-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        String a = buffer.readLine(),b,c;
        int maxA, maxB, maxC;
        maxA = updateFreq(a);
        b = buffer.readLine();
        maxB = updateFreq(b);
        c = buffer.readLine();
        maxC = updateFreq(c);
        if (n == 1 && maxA == a.length())a = a.substring(0, a.length()-1);
        if (n == 1 && maxB == b.length())b = b.substring(0, b.length()-1);
        if (n == 1 && maxC == c.length())c = c.substring(0, a.length()-1);
        maxA = Math.min(maxA+n, a.length());
        maxB = Math.min(maxB+n, b.length());
        maxC = Math.min(maxC+n, c.length());
        if (maxA > maxB && maxA > maxC)
            System.out.println("Kuro");
        else if (maxB > maxA && maxB > maxC)
            System.out.println("Shiro");
        else if (maxC > maxA && maxC > maxB)
            System.out.println("Katie");
        else
            System.out.println("Draw");
    }
}
