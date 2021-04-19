import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayAndPeaks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            if ((n < 3 || (k > n/2 && n % 2 == 1 || k >= n/2 && n % 2 == 0)) && k != 0)
                sb.append(-1+"\n");
            else {
                int [] arr = new int[n];
                for (int i = 0; i < n ; i++) {
                    arr[i] = i+1;
                }
                for (int i = 1, j = 0; i < n-1 && j < k; i+=2, j++) {
                    arr[i] = arr[i]^arr[i+1]^(arr[i+1] = arr[i]);
                }
                for (int num : arr) {
                    sb.append(num+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
