import java.io.*;
import java.util.*;

public class RationalLee {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            Integer [] nums = new Integer[n];
            for (int pos = 0; pos < n; pos++) {
                nums[pos] = Integer.parseInt(inp[pos]);
            }
            inp = buffer.readLine().split(" ");
            int [] toGive = new int[k];
            for (int pos = 0; pos < k; pos++) {
                toGive[pos] = Integer.parseInt(inp[pos]);
            }
            Arrays.sort(toGive);
            Arrays.sort(nums, Collections.reverseOrder());
            long happiness = 0;
            for (int pos = 0; pos < k; pos++) {
                happiness += nums[pos];
                if (toGive[pos]==1)
                    happiness += nums[pos];
            }
            int pos2 = 0;
            for (int pos = k-1; pos < n && pos2 < k;) {
                if (toGive[pos2]==1){pos2++;continue;}
                pos += toGive[pos2]-1;
                happiness += nums[pos];
                pos2++;
            }
            System.out.println(happiness);

        }
        System.out.println(sb);
    }
}
