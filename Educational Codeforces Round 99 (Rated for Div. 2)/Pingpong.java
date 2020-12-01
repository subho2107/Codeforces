import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pingpong {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            sb.append((x-1)+" "+y).append("\n");
        }
        System.out.println(sb);
    }
}
