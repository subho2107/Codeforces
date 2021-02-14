import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddAndDivide {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            if (b >= a){
                if (b == a)
                    sb.append("2\n");
                else
                    sb.append("1\n");
            }
            else {
                int cost = 0, prevCost = -1, org = b,ans = Integer.MAX_VALUE;
                if (b == 1)
                    b++;
                while (true){
                    double temp = Math.log(a)/Math.log(b) + b - org;
                    cost = (int) temp;
                    if (a % b == 0 || temp > cost)
                    cost++;
                    ans = Math.min(ans, cost);
                    if (cost > prevCost && prevCost != -1)
                        break;
                    b++;
                    prevCost = cost;
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}
