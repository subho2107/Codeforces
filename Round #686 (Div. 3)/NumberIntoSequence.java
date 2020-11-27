import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberIntoSequence {
    public static long primeFactors(long n)
    {
        List<long[]>factors = new ArrayList<>();
        int cnt = 0;
        while (n%2==0)
        {
            cnt++;
            n /= 2;
        }
        if (cnt != 0)
            factors.add(new long[]{2, cnt});
        for (long i = 3; i <= Math.sqrt(n); i+= 2)
        {
            cnt = 0;
            while (n%i == 0)
            {
                cnt++;
                n /= i;
            }
            if (cnt > 0)
                factors.add(new long[]{i, cnt});
        }
        if (n > 2)
            factors.add(new long[]{n, 1});
        long maxVal = 0, maxFreq = Integer.MIN_VALUE;
        for (long[] factor : factors) {
            if (factor[1] > maxFreq){
                maxFreq = factor[1];
                maxVal = factor[0];
            }
        }
        return maxVal;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(buffer.readLine());

            long div = primeFactors(n);
            long cnt = 0;
            long dup = n;
            while (dup % (div*div) == 0) {
                cnt++;
                dup /= div;
            }
            sb.append(cnt + 1).append("\n");
            for (int i = 0; i < cnt; i++) {
                sb.append(div + " ");
            }
            sb.append(dup + "\n");

        }
        System.out.println(sb);
    }
}
