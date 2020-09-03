import java.io.*;
import java.util.*;

public class BoatsCompetition {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int [] cnt  = new int[101];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                cnt[arr[pos]]++;
            }
            int ans = 0;
            for (int s = 2; s <= 100; s++) {
                int temp = 0;
                for (int currW = 1; currW <= s/2; currW++) {
                    if (currW==s/2 && s%2==0) temp+=cnt[currW]/2;
                    else
                        temp += Math.min(cnt[currW], cnt[s-currW]);
                }
                ans = Math.max(ans, temp);
            }
            sb.append(ans+"\n");

        }
        System.out.println(sb);
    }
}
