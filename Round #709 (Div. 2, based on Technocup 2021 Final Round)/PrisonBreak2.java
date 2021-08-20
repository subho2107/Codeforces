import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrisonBreak2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            sb.append(a*b).append("\n");
        }
        System.out.println(sb);
    }
}
