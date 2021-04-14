import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SpyDetected {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            HashMap<Integer, Integer>map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }
            int a = 0;
            for (int num : map.keySet()) {
                if (map.get(num) == 1)
                    a = num;
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == a)
                    sb.append(i+1).append("\n");
            }
        }
        System.out.println(sb);
    }
}