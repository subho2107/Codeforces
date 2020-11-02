import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseBinaryStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String bin = buffer.readLine();
            int one = 0, zero = 0;
            for (int i = 0; i < n-1; i++) {
                char c = bin.charAt(i), d = bin.charAt(i+1);
                if (c == '1' && d == '1')
                    one++;
                else if (c == '0' && d == '0')
                    zero++;

            }
            zero = Math.max(zero, one);
            sb.append(zero + "\n");
        }
        System.out.println(sb);
    }
}
