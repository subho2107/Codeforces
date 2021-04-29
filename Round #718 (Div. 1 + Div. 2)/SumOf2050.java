import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOf2050 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine()) ;
            long ans = n/2050;
            if (ans == 0 || n % 2050 != 0)
                sb.append(-1+"\n");
            else {
                long sum = 0;
                while (ans != 0){
                    sum += ans % 10;
                    ans /= 10;
                }
                sb.append(sum + "\n");
            }
        }
        System.out.println(sb);
    }
}
