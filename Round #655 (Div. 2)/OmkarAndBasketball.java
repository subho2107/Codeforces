import javax.swing.*;
import java.io.*;
import java.util.*;

public class OmkarAndBasketball {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int [] arr2 = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                arr2[pos] = Integer.parseInt(inp[pos]);
            }
            int startPos = -1, lastPos = -1;
            boolean flag = false;
            Arrays.sort(arr2);
            for (int pos = 0; pos < n; pos++) {
                if (arr[pos] != arr2[pos])
                {
                    if (!flag)
                    {
                        flag = true;
                        startPos = pos;
                    }
                    lastPos = pos;
                }
            }
            if (startPos==-1)
                sb.append(0).append("\n");
            else {
                flag = false;
                for (int pos = startPos; pos <= lastPos; pos++) {
                    if (arr[pos] == arr2[pos]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    sb.append(2).append("\n");
                }
                else
                    sb.append(1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
