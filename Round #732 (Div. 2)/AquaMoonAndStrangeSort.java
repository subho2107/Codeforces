import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AquaMoonAndStrangeSort {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            ArrayList<Integer>odd = new ArrayList<>(), even = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i]);
                if (i % 2 == 1)
                    even.add(num);
                else
                    odd.add(num);
            }
            Collections.sort(odd);
            Collections.sort(even);
            int [] arr = new int[n];
            for (int i = 0, j = 0, k = 0; i < n; i++) {
                if (i % 2 == 0)
                    arr[i] = odd.get(j++);
                else
                    arr[i] = even.get(k++);
            }
            boolean check = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i+1])
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
