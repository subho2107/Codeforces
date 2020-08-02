import java.io.*;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class CutRibbon {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), a = Integer.parseInt(inp[1]), b = Integer.parseInt(inp[2]), c = Integer.parseInt(inp[3]);
        int [] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int ribbon = 1; ribbon < n + 1; ribbon++) {
            if (a<=ribbon)
                dp[ribbon] = dp[ribbon-a]+1;
            if (b<=ribbon && dp[ribbon-b]+1>dp[ribbon])
                dp[ribbon] = dp[ribbon-b]+1;
            if (c<=ribbon && dp[ribbon-c]+1>dp[ribbon])
                dp[ribbon] = dp[ribbon-c]+1;
        }
        System.out.println(dp[n]);
    }
}
