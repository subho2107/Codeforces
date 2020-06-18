import java.io.*;
import java.util.*;

public class Codeforces_Subsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            long k = Long.parseLong(buffer.readLine());
            String text = "codeforces";
            String ans = "";
            int[]arr = new int[10];
            Arrays.fill(arr, 1);
            long prod = 1L;
            while (prod< k)
            {
                for (int pos = 0; pos < 10; pos++) {
                    arr[pos]++;
                    prod *= arr[pos];
                    prod/= arr[pos]-1;
                    if (prod>=k)break;

                }
            }
            for (int pos = 0; pos < 10; pos++) {
                ans+= Character.toString(text.charAt(pos)).repeat(arr[pos]);
            }
            System.out.println(ans);
        }

    }
}
