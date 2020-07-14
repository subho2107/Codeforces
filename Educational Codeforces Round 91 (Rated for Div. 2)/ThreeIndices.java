import java.io.*;
import java.util.*;

public class ThreeIndices {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[]inp = buffer.readLine().split(" ");
            int[]arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            boolean check = false;
            for (int pos = 1; pos < n - 1; pos++) {
                int a = -1;
                for (int posL = 0; posL < pos; posL++) {
                    if (arr[pos] > arr[posL])
                    {
                        a = posL+1;
                        break;
                    }
                }
                if (a != -1)
                {
                    int b = -1;
                    for (int posR = pos+1; posR < n; posR++) {
                        if (arr[pos] > arr[posR])
                        {
                            b = posR+1;
                            break;
                        }
                    }
                    if ( b != -1)
                    {
                        check = true;
                        sb.append("YES\n");
                        sb.append(a).append(" ").append(pos+1).append(" ").append(b).append("\n");
                        break;
                    }
                }
            }
            if (!check)
            {
                sb.append("NO\n");
            }

        }
        System.out.println(sb);
    }
}
