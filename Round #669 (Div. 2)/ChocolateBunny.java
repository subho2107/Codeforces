import java.io.*;
import java.util.*;

public class ChocolateBunny {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int maxNumPos = 0;
        int[] ans = new int[n];
        for (int pos = 1; pos < n; pos++) {
            System.out.println("? " + (maxNumPos + 1) + " " + (pos + 1));
            System.out.flush();
            int rem1 = Integer.parseInt(buffer.readLine());
            System.out.println("? " + (pos + 1) + " " + (maxNumPos + 1));
            System.out.flush();
            int rem2 = Integer.parseInt(buffer.readLine());
            if (rem1 > rem2) {
                ans[maxNumPos] = rem1;
                maxNumPos = pos;
            } else
                ans[pos] = rem2;
        }
        ans[maxNumPos] = n;
        System.out.print("! ");
        for (int pos = 0; pos < n; pos++) {
            System.out.print(ans[pos] + " ");
        }
        System.out.println();
        System.out.flush();
    }
}

