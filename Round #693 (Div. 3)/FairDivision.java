import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FairDivision {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int one = 0, two = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                if (num == 1)one++;
                else two++;
            }
            if (one % 2 == 0 && two % 2 == 0)
                sb.append("YES\n");
            else {
                if (one % 2 == 1 && two % 2 == 1)
                    sb.append("NO\n");
                else if (two % 2 == 0 && one % 2 == 1)
                    sb.append("NO\n");
                else if (two % 2 == 1 && one % 2 == 0 && one >= 2)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
