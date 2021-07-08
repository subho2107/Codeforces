import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExcitingBets {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long a = Long.parseLong(inp[0]), b = Long.parseLong(inp[1]);
            if (a == b){
                sb.append("0 0\n");
                continue;
            }
            if (a < b)
                a = a^b^(b = a);
            long gcd = a-b;
                long fact = b/gcd;
                long diff = Math.min(Math.abs(b-fact*gcd), Math.abs((fact+1)*gcd-b));
                sb.append(gcd+" "+diff+"\n");
        }
        System.out.println(sb);
    }
}
