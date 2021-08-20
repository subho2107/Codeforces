import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCDSum {
    public static long gdc(long a, long b){
        if (b == 0)
            return a;
        return gdc(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine());
            for (long i = n;; i++) {
                long sum = 0;
                long dup = i;
                while (dup != 0){
                    sum += dup % 10;
                    dup /= 10;
                }
                if (gdc(sum, i) != 1){
                    sb.append(i+"\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
