import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ValeriiAgainstEveryone {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            HashSet<Integer>hashSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                hashSet.add(arr[i]);
            }
            if (hashSet.size() < n)
                sb.append("YES\n");
            else
                sb.append("NO\n");

        }
        System.out.println(sb);
    }
}
