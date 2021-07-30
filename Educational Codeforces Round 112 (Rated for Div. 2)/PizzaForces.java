import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PizzaForces {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine());
            if (n % 2 != 0)
                n++;
            long val =(n/2)*5;
            val = Math.max(15, val);
            sb.append(val+"\n");

        }
        System.out.println(sb);
    }
}
