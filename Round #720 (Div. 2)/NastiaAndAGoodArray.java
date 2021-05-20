import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NastiaAndAGoodArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                if (arr[minIndex] > arr[i])
                    minIndex = i;
            }
            sb.append(n-1+"\n");
            minIndex++;
            int a = arr[minIndex-1], b = a+1;
            int c = 1;
            for (int i = minIndex-1; i >= 1; i--) {
                sb.append(minIndex+" "+i+" "+a+" "+(a+c)).append("\n");
                c++;
            }
            c = 1;
            for (int i = minIndex+1; i <= n; i++) {
                sb.append(minIndex+" "+i+" "+a+" "+(a+c)).append("\n");
                c++;
            }
        }
        System.out.println(sb);
    }
}
