import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NastiaAndNearlyGoodNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int A = Integer.parseInt(inp[0]), B = Integer.parseInt(inp[1]);
            long a = B-1 , b = 1, c = 1;
//            if (a == 2)
//                a =
            long temp = (long) A*B;
            long x = A*a, y = A*b, z = temp*c;
            if (x+y == z && (x != y && y != z))
            {
                sb.append("YES\n");
                sb.append(x+" "+y+" "+z+"\n");
            }
            else {
                a = 1;b = B+1;
                x = A*a; y = temp*c; z = A*b;
                if (x+y == z && (x != y && y != z))
                {
                    sb.append("YES\n");
                    sb.append(x+" "+y+" "+z+"\n");
                }
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
