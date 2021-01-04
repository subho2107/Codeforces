import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VanyaAndFence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), h = Integer.parseInt(inp[1]);
        inp = buffer.readLine().split(" ");
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inp[i]);
            ans++;
            if (num > h)
                ans++;
        }
        System.out.println(ans);
    }
}
