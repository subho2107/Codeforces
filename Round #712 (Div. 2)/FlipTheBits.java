import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FlipTheBits {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String a = buffer.readLine();
            String b = buffer.readLine();
            a+= '0';
            b+='0';
            int one = 0, zero = 0;
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1')one++;
                else zero++;
                if ((a.charAt(i) == b.charAt(i))!=(a.charAt(i+1) == b.charAt(i+1)) && zero != one ){
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
