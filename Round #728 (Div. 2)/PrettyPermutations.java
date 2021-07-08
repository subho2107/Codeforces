import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrettyPermutations {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i+1;
            }
            for (int i = 0; i < n-1; i+=2) {
                arr[i] = arr[i]^arr[i+1]^(arr[i+1] = arr[i]);
            }
            if (n >= 3 && n % 2 == 1)
                arr[n-1] = arr[n-1]^arr[n-2]^(arr[n-2] = arr[n-1]);
            for (int i : arr) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}