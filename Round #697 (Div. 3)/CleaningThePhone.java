import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CleaningThePhone {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [][] vals = new int[n][2];
            for (int i = 0; i < n; i++) {
                vals[i][0] = Integer.parseInt(inp[i]);
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                vals[i][1] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(vals, (o1, o2) -> {
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            });
            int lastPosOf1 = -1;
            for (int i = 0; i < n; i++) {
                if (vals[i][1] == 1)
                    lastPosOf1 = i;
            }
            int ones = lastPosOf1, twos = n-1;
            int currMemoryReduced = 0;
            int cnt = 0;
            while (currMemoryReduced < m && (ones >= 0 || vals[twos][1] == 2)){
               if (ones-1 >= 0 && vals[ones][0] + vals[ones-1][0] > vals[twos][0]){
                    currMemoryReduced += vals[ones][0] + vals[ones-1][0];
                    ones -= 2;
                    cnt+=2;
                }
                else if (vals[twos][1] == 2)
                {
                    currMemoryReduced += vals[twos][0];
                    twos--;
                    cnt+=2;
                }
                else if (ones >= 0)
                {
                    currMemoryReduced += vals[ones][0];
                    ones--;
                    cnt++;
                }
            }
            if (currMemoryReduced >= m)
                sb.append(cnt+"\n");
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
