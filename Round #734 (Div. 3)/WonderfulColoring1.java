import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WonderfulColoring1 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            int [] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
            int cnt = 0, cnt2 = 0;
            for (int i : freq) {
                if (i >= 2)
                    cnt++;
                else if (i == 1)
                    cnt2++;
            }
            int ans = cnt+(cnt2/2);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
