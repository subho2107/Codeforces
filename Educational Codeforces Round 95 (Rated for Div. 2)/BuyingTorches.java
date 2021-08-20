import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuyingTorches {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
            long ans = k*(y+1)+((k-1)/(x-1));
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
