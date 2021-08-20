import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SameDifferences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer>hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i])-(i+1);
                hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
            }
            long ans = 0;
            for (Integer value : hashMap.values()) {
                ans += (long) value *(value-1)/2;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
