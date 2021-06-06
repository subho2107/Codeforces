import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class GameOfLife {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            char [] arr = buffer.readLine().toCharArray();
            for (int i = 0; i < Math.min(n, m); i++) {
                HashSet<Integer>positions = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (arr[j] == '1')
                        continue;
                    int cnt = 0;
                    if (j-1 >= 0 && arr[j-1] == '1')
                        cnt++;
                    if (j+1 < n && arr[j+1] == '1')
                        cnt++;
                    if (cnt == 1)
                        positions.add(j);
                }
                for (int pos : positions) {
                    arr[pos] = '1';
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
