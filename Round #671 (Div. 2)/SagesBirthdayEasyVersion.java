import java.io.*;
import java.util.*;

public class SagesBirthdayEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] arr = new int[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        Arrays.sort(arr);
        int [] ans = new int[n];
        int dup = n-1;
        for (int i = 0; i < n; i+=2, dup--) {
            ans[i] = arr[dup];
        }
        int cnt = 0;
        for (int i = 1; i < n; i+=2, dup--) {
            ans[i] = arr[dup];
        }
        for (int i = 1; i < n - 1; i++) {
            if (ans[i] < ans[i-1] && ans[i] < ans[i+1]){
                cnt++;
            }
        }
        System.out.println(cnt);
        for (int pos = 0; pos < n; pos++) {
            sb.append(ans[pos] + " ");
        }
        System.out.println(sb);
    }
}