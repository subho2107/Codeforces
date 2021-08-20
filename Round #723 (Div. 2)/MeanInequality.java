import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MeanInequality {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[2*n];
            for (int i = 0; i < 2*n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            int i = 0, j = arr.length-1;
            while (i <= j){
                sb.append(arr[i]+" ");
                i++;
                sb.append(arr[j]+" ");
                j--;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
