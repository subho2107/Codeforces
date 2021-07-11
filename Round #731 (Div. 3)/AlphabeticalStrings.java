import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphabeticalStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int [] pos = new int[26];
            String s = buffer.readLine();
            boolean check = true;
            Arrays.fill(pos, -1);
            char maxChar = 'a';
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pos[ch-'a'] != -1){
                    check = false;
                    break;
                }
                maxChar = (char) Math.max(maxChar, ch);
                pos[ch-'a'] = i;
            }
            if (pos[0] == -1){
                sb.append("NO\n");
                continue;
            }
            if (!check){
                sb.append("NO\n");
                continue;
            }
            int left = pos[0], right = pos[0];
            for (char i = 'b'; i <= maxChar; i++) {
                if (pos[i - 'a'] == -1){
                    check = false;
                    break;
                }
                if (pos[i - 'a'] == left - 1){
                    left--;
                }
                else if (pos[i-'a'] == right+1)
                    right++;
                else
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
