import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class MorningJogging {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [][] matrix = new int[n][m];
            int pos = 0;
            int [][] arr = new int[n*m][2];
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(inp[j]);
                    arr[pos++] = new int[]{i, j};
                }
            }
            int [][] ans = new int[n][m];
            Arrays.sort(arr, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
            for (int i = m-1; i >= 0 ; i--) {
                ans[arr[i][0]][arr[i][1]] = i+1;
            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    sb.append(ans[i][j]+" ");
//                }
//                sb.append("\n");
//            }
//            sb.append("\n");
            for (int i = 0; i < n; i++) {
                HashSet<Integer>set = new HashSet<>();
                for (int num : ans[i]) {
                    if (num == 0)
                        continue;
                    set.add(num);
                }
                Stack<Integer>stack = new Stack<>();
                for (int j = 1; j <= m; j++) {
                    if (!set.contains(j))
                        stack.add(j);
                }
                for (int j = 0; j < m; j++) {
                    if (ans[i][j] != 0)continue;
                    ans[i][j] = stack.pop();
                }
            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    sb.append(ans[i][j]+" ");
//                }
//                sb.append("\n");
//            }
//            sb.append("\n");
            int [][] finalAns = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    finalAns[i][ans[i][j]-1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(finalAns[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
