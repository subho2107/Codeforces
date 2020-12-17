import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CancelTheTrains {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            HashSet<Integer>a = new HashSet<>();
            HashSet<Integer>b = new HashSet<>();
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(inp[i]));
            }
            inp = buffer.readLine().split( " ");
            for (int i = 0; i < m; i++) {
                b.add(Integer.parseInt(inp[i]));
            }
            int cnt = 0;
            for (Integer integer : a) {
                if (b.contains(integer))
                    cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
