import java.io.*;
import java.util.*;

public class TheStrongestBuild {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Integer>[]weapons = new ArrayList[n];
            int [] maxBuild = new int[n];
            String [] inp;
            for (int i = 0; i < n; i++) {
                weapons[i] = new ArrayList<>();
                inp = buffer.readLine().split(" ");
                int c = Integer.parseInt(inp[0]);
                for (int j = 1; j <= c; j++) {
                    weapons[i].add(Integer.parseInt(inp[j]));
                }
            }
            for (int i = 0; i < n; i++) {
                maxBuild[i] = weapons[i].size()-1;
            }
            Set<String>bannedBuildsSet = new HashSet<>();
            int m = Integer.parseInt(buffer.readLine());
            int [][] bannedBuilds = new int[m][n];
            for (int i = 0; i < m; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    bannedBuilds[i][j] = Integer.parseInt(inp[j])-1;
                }
                bannedBuildsSet.add(Arrays.toString(bannedBuilds[i]));
            }
            int [] ans = new int[n];
            if (!bannedBuildsSet.contains(Arrays.toString(maxBuild)))
                ans = maxBuild;
            else {
                int maxSum = 0;
                for (int[] bannedBuild : bannedBuilds) {
                    int sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += weapons[i].get(bannedBuild[i]);
                    }
                    for (int i = 0; i < n; i++) {
                        if (bannedBuild[i] == 0)
                            continue;
                        int currSum = sum - weapons[i].get(bannedBuild[i]) + weapons[i].get(bannedBuild[i]-1);
                        bannedBuild[i]--;
                        if (currSum > maxSum && !bannedBuildsSet.contains(Arrays.toString(bannedBuild))) {
                            maxSum = currSum;
                            ans = Arrays.copyOf(bannedBuild, n);
                        }
                        bannedBuild[i]++;
                    }
                }
            }
            for (int an : ans) {
                sb.append(an + 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}
