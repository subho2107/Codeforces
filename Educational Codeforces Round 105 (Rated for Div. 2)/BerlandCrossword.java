import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BerlandCrossword {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), u = Integer.parseInt(inp[1]), r = Integer.parseInt(inp[2]),
                    d = Integer.parseInt(inp[3]), l = Integer.parseInt(inp[4]);
            boolean check = false;
            int [][] matrix = new int[n][n];
            for (int bitMask = 0; bitMask < 16; bitMask++) {
                matrix[0][0] = (bitMask&1)!=0?1:0;
                matrix[0][n-1] = ((bitMask>>1)&1)!=0?1:0;
                matrix[n-1][0] = ((bitMask>>2)&1)!=0?1:0;
                matrix[n-1][n-1] = ((bitMask>>3)&1)!=0?1:0;
                int forUp = matrix[0][0]+matrix[0][n-1], forRight = matrix[0][n-1]+matrix[n-1][n-1],
                        forDown = matrix[n-1][0]+matrix[n-1][n-1], forLeft = matrix[0][0]+matrix[n-1][0];
                if (u-forUp <= n-2 && r-forRight <= n-2 && d-forDown<=n-2 && l-forLeft<=n-2 && u-forUp>=0 && r-forRight >= 0 && d-forDown>=0 && l-forLeft>=0)
                {
                    check = true;
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
