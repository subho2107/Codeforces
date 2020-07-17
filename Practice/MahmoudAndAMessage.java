import java.io.*;
import java.util.*;

public class MahmoudAndAMessage {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            String[] inp = buffer.readLine().split(" ");
            long[] cnt = new long[26];
            long[] dp = new long[n];
            dp[0] = 1;
            for (int pos = 0; pos < inp.length; pos++) {
                cnt[pos] = Integer.parseInt(inp[pos]);
            }
            int MOD = 1000000007;
            int maxLen = 1;
            //Calculating the possible ways to divide the string and max  len substring
            for (int pos = 1; pos < n; pos++) {
                boolean[] visited = new boolean[26];
                visited[s.charAt(pos) - 'a'] = true;
                for (int pos2 = pos; pos2 >= 0; pos2--) {
                    visited[s.charAt(pos2) - 'a'] = true;
                    int currLen = pos - pos2 + 1;
                    boolean check = true;
                    for (int ch = 0; ch < 26; ch++) {
                        if (visited[ch])
                            if (currLen > cnt[ch])
                                check = false;
                    }
                    if (check) {
                        maxLen = Math.max(maxLen, currLen);
                        long possSubs = (pos2 == 0) ? 1 : dp[pos2 - 1];
                        dp[pos] = (dp[pos] + possSubs) % MOD;
                    } else
                        break;
                }
            }
            //calculating the longest possible substring and the minimum no of part in which the string can be divided
            int minParts = 0;
            while (s.length() != 0) {
                int pos;
                boolean[] visited = new boolean[26];
                for (pos = 0; pos < s.length(); pos++) {
                    visited[s.charAt(pos) - 'a'] = true;
                    boolean check = true;
                    for (int ch = 0; ch < 26; ch++) {
                        if (visited[ch])
                            if (cnt[ch] < pos + 1) {
                                check = false;
                                break;
                            }
                    }
                    if (!check)
                        break;
                }
                s = s.substring(pos);
                minParts++;
            }
            sb.append(dp[n - 1]).append("\n").append(maxLen).append("\n").append(minParts);
        }
        System.out.println(sb);
    }
}
