import java.io.*;
import java.util.*;

public class CreatetheTeams {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            Arrays.sort(arr);
            int teams = 0, currTeamCnt = 1;
            for (int pos = n-1; pos >= 0 ; pos--) {
                if (arr[pos]*currTeamCnt >= x)
                {
                    teams++;
                    currTeamCnt = 1;
                }
                else
                    currTeamCnt++;
            }
            sb.append(teams).append("\n");
        }
        System.out.println(sb);
    }
}
