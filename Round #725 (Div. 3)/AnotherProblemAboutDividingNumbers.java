import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnotherProblemAboutDividingNumbers {
    public static int primeFactors(int n)
    {
        int cnt = 0;
        while (n%2==0)
        {
            cnt++;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                cnt++;
                n /= i;
            }
        }
        if (n > 2)
            cnt++;
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]),b = Integer.parseInt(inp[1]),k = Integer.parseInt(inp[2]);
            int max = Math.max(a, b), min = Math.min(a, b);
            if (primeFactors(a)+primeFactors(b) < k || (k == 1 && !(max % min == 0 && max/min != 1)))
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
