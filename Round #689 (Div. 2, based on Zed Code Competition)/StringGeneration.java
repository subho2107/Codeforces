import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringGeneration {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            for (int i = 0; i < n; i++) {
                if (i % 3 == 0)
                sb.append('a');
                else if (i % 3 == 1)
                    sb.append('b');
                else
                    sb.append('c');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
