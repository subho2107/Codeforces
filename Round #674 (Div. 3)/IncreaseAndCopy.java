import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IncreaseAndCopy {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(buffer.readLine());
            long root = (long) Math.sqrt(n);
            long ans= root-1;
            ans+=n/(root);
            if (n%root==0)
                ans--;
            sb.append(ans+"\n");

        }
        System.out.println(sb);
    }
}
