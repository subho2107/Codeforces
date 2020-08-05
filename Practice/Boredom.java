import java.io.*;
import java.util.*;

public class Boredom {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        buffer.readLine();
        int n = 100001;
        long [] cnt = new long[n];
        String [] inp = buffer.readLine().split(" ");
        for (int pos = 0; pos < inp.length; pos++) {
            int num = Integer.parseInt(inp[pos]);
            cnt[num]++;
        }
        long [] dp = new long[n];
        dp[0] = 0;dp[1] = cnt[1];
        for (int pos = 2; pos < n; pos++) {
            dp[pos] = Math.max(dp[pos-1], dp[pos-2]+ cnt[pos]*pos);
        }

        System.out.println(dp[n-1]);
    }
}
