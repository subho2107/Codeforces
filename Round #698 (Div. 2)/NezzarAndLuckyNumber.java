import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NezzarAndLuckyNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), d = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                int div = num/d, rem = num % d;
                boolean check = false;
                if (div >= 10)
                    sb.append("YES\n");
                else {
                    for (int j = 1; j <= div; j++) {
                        if ((d*j+rem)%10 == d){
                            check = true;
                            break;
                        }
                    }
                    if (check)
                        sb.append("YES\n");
                    else
                        sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
