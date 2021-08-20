import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class RunningForGold {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [][] ranks = new int[n][6];//ranks[i][0] is the index
            for (int i = 0; i < n; i++) {
                String [] inp = buffer.readLine().split(" ");
                ranks[i][0] = i+1;
                for (int j = 0; j < 5; j++) {
                    ranks[i][j+1]= Integer.parseInt(inp[j]);
                }
            }
            Arrays.sort(ranks, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int a = 0;
                    for (int i = 1; i < 6; i++) {
                        if (o1[i] < o2[i])
                            a++;
                    }

                    if (a >= 3)
                        return 1;
                    else return -1;
                }
            });
            int ans = ranks[n-1][0];
            for (int i = 0; i < n - 1; i++) {
                int cnt = 0;
                for (int j = 1; j < 6; j++) {
                    if (ranks[n-1][j] < ranks[i][j])
                        cnt++;
                }
                if (cnt < 3){
                    ans = -1;
                    break;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
