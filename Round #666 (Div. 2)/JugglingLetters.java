import java.io.*;
import java.util.*;

public class JugglingLetters {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] freq = new int[26];
            for (int pos = 0; pos < n; pos++) {
                String s = buffer.readLine();
                for (char ch:s.toCharArray())
                    freq[ch-'a']++;
            }
            boolean check = true;
            for (int pos = 0; pos < 26; pos++) {
                if (freq[pos]==0)continue;
                if (freq[pos]%n!=0){
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.println(sb);
    }
}
