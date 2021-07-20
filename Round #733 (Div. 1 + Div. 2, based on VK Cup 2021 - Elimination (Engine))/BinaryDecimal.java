import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryDecimal {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int max = 0;
            while (n != 0){
                max = Math.max(n%10, max);
                n /= 10;
            }
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
}
