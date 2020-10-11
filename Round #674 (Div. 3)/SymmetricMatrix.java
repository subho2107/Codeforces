import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SymmetricMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            boolean check = false;
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                int a=Integer.parseInt(inp[1]);
                inp = buffer.readLine().split(" ");
                int b = Integer.parseInt(inp[0]);
                if (a==b)
                    check = true;
            }
            if (m%2==1||!check){
                sb.append("NO\n");
            }
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
