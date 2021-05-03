import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoenixAndGold {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            long sum = 0;
            int pos = -1;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == x)
                    pos = i;
            }
            if (pos == -1){
                sb.append("YES\n");
                for (int num : arr) {
                    sb.append(num+" ");
                }
                sb.append("\n");
            }
            else if (arr[pos] != arr[n-1]){
                sb.append("YES\n");
                for (int i = 0; i < pos; i++) {
                    sb.append(arr[i]+" ");
                }
                sb.append(arr[n-1]+" ");
                for (int i = pos; i < n-1; i++) {
                    sb.append(arr[i]+" ");
                }
                sb.append("\n");
            }
            else {
                if (sum == x)
                    sb.append("NO\n");
                else {
                    sum = 0;
                    int i = n-1;
                    boolean check = false;
                    for (i = n-1; i >= 1; i--) {
                        sum += arr[i];
                        if (sum == x)
                            continue;
                        long tempSum = sum;
                        check = true;
                        for (int j = 0; j < i; j++) {
                            tempSum += arr[j];
                            if (tempSum == x)
                            {
                                check = false;
                                break;
                            }
                        }
                        if (check)
                            break;
                    }
                    if (!check)
                        sb.append("NO\n");
                    else {
                        sb.append("YES\n");
                        for (int j = n - 1; j >= i; j--) {
                            sb.append(arr[j] + " ");
                        }
                        for (int j = 0; j < i; j++) {
                            sb.append(arr[j]+" ");
                        }
                        sb.append("\n");
                    }
                }
            }

        }
        System.out.println(sb);
    }
}
