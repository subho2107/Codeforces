import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class MoamenAndkSubarrays {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int [] arr = new int[n], dup = new int[n];
            HashMap<Integer, Integer>map = new HashMap<>();
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                map.put(arr[i], i);
                dup[i] = arr[i];
            }
            Arrays.sort(dup);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int j = map.get(dup[i]);
                while (j < n && i < n  && arr[j] == dup[i]){
                    j++;
                    i++;
                }
                cnt++;
                i--;
            }
            if (cnt > k)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
