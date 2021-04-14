import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlmostRectangle {
    static long gcd1(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd1(b, a % b);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), c = Integer.parseInt(inp[2]);
            long gcdProb = (long) Math.pow(10, c-1), a1 = (long) (Math.pow(10, a)-1), b1 = (long) (Math.pow(10, b)-1);
            long ans1 = a1/gcdProb, ans2 = b1/gcdProb;
            if (ans1 == ans2)
                ans2--;
            ans1 *= gcdProb;ans2*=gcdProb;
            long gcdActual = gcd1(ans1, ans2);
            while (Long.toString(gcdActual).length() != c){
                gcdProb++;
                ans1 = a1/gcdProb; ans2 = b1/gcdProb;
                if (ans1 == ans2)
                    ans2--;
                ans1 *= gcdProb;ans2*=gcdProb;
                gcdActual = gcd1(ans1, ans2);
            }
            sb.append(ans1).append(" ").append(ans2).append("\n");
        }
        System.out.println(sb);
    }
}
