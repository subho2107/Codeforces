import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DifferentDivisors {
    public static boolean isPrime(long num){
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(buffer.readLine());
            long a = 1+d;
            while (!isPrime(a))
                a++;
            long b = a;
            a += d;
            while (!isPrime(a))
                a++;
            long ans = a*b;
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
