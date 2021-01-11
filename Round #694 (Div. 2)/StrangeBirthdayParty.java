import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class StrangeBirthdayParty {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            ArrayList<Integer> k = new ArrayList<>();
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++)
                k.add(Integer.parseInt(inp[i])-1);
            Collections.sort(k);
            int[] c = new int[m];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < m; i++)
                c[i] = Integer.parseInt(inp[i]);
            int j = n - 1;
            long cost = 0;
            for (int i = 0; i < m && j >= 0 && i <= k.get(j); i++, j--) {
                cost += c[i];
            }
            for (int i = j; i >= 0; i--) {
                cost += c[k.get(i)];
            }
            sb.append(cost).append("\n");
        }
        System.out.println(sb);
    }
}
