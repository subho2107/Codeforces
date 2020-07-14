import javax.swing.*;
import java.io.*;
import java.util.*;

public class SignFlipping {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[]inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            for (int pos = 0; pos < n-1 ;pos++) {
                if (pos%2==0) {
                    int a = arr[pos], b = arr[pos + 1];
                    if (b - a <= 0) continue;
                    //                arr[pos] = a; arr[pos+1] = -b;
                    if ((-b) - a <= 0) {
                        arr[pos] = a;
                        arr[pos + 1] = -b;
                    } else if (b + a <= 0) {
                        arr[pos] = -a;
                        arr[pos + 1] = b;
                    } else {
                        arr[pos] = -a;
                        arr[pos + 1] = -b;
                    }
                }
                else
                {
                    int a = arr[pos], b = arr[pos+1];
                    if (b-a >= 0)continue;
//                arr[pos] = -a; arr[pos+1] = b;
                    if ((-b)-a>=0)
                    {
                        arr[pos] = a;
                        arr[pos+1] = -b;
                    }
                    else if (b+a>=0)
                    {
                        arr[pos] = -a;
                        arr[pos+1] = b;
                    }
                    else
                    {
                        arr[pos] = -a;
                        arr[pos+1] = -b;
                    }
                }
            }
            for (int num :
                    arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
