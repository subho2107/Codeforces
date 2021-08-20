import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayReodering {
    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            ArrayList<Integer>list = new ArrayList<>();
            for (int num : arr) {
                if (num % 2 == 0)
                    list.add(num);
            }
            for (int num : arr) {
                if (num % 2 == 1)
                    list.add(num);
            }
            int cnt =0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (gcd(list.get(i), 2*list.get(j)) > 1)
                        cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
