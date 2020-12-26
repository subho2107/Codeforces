import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoveAndTurn {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        if(n % 2 == 0) {
            n/=2;
            n++;
            long square = (long) n*n;
            System.out.println(square);
        }
        else {
            n++;
            n /= 2;
            int num = 0,increment = 1;
            for (int i = 0; i < n; i++, increment++) {
                num += increment;
            }
            long ans = 4L *num;
            System.out.println(ans);
        }
    }
}
