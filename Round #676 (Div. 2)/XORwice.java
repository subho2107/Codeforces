import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XORwice {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            long x = 0;
            long [] pow2 = new long[31];
            pow2[0] = 1;
            for (int i = 1; i < 31; i++) {
                pow2[i] = 2*pow2[i-1];
            }
            for (int i = 0; i < 31; i++) {
                int setA = (a>>i)&1, setB = (b>>i)&1;
                if (setA==1 && setB == 1)
                    x+=pow2[i];
            }
            long ans = (a^x)+(b^x);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
