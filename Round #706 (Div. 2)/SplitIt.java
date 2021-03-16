import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SplitIt {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            if (k == 0)
                sb.append("YES\n");
            else {
                boolean check = false;
                int i = k, j = n - k;
                while (i < j) {
                    if (s.substring(0, i).equals(new StringBuilder(s.substring(j)).reverse().toString())) {
                        check = true;
                        break;
                    }
                    i++;
                    j--;
                }
                if (check)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
