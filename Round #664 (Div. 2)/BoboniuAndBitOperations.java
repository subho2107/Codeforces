import java.io.*;
import java.util.*;

public class BoboniuAndBitOperations {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
        inp = buffer.readLine().split(" ");
        int[] a = new int[n];
        int[] b = new int[m];
        for (int pos = 0; pos < n; pos++) {
            a[pos] = Integer.parseInt(inp[pos]);
        }
        inp = buffer.readLine().split(" ");
        for (int pos = 0; pos < m; pos++) {
            b[pos] = Integer.parseInt(inp[pos]);
        }
        int ans = 0;
        boolean check;
        for (; ans < 1e9; ans++) {
            check = false;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                check = false;
                for (int j = 0; j < m; j++) {
                    int val = (a[i] & b[j]) & (~ans);
                    if (val == 0) {
                        temp |= a[i]&b[j];
                        check = true;
                        break;
                    }
                }
                if (!check)
                    break;
            }
            if (check && temp==ans)
                break;
        }
        System.out.println(ans);
    }
}
