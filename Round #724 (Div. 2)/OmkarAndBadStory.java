import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OmkarAndBadStory {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            if (min < 0){
                sb.append("NO\n");
                continue;
            }
            min = Math.min(min, 1);
            boolean check = true;
            for (int i = min; i <= max; i++) {
                for (int j = i+1; j <= max; j++) {
                    int diff = Math.abs(i - j);
                    if (diff < min || diff > max)
                    {
                        check = false;
                        break;
                    }
                }
            }
            if (check)
            {
                sb.append("YES\n");
                sb.append(max-min+1).append("\n");
                for (int i = min; i <= max; i++) {
                    sb.append(i+" ");
                }
                sb.append("\n");
            }
            else
                sb.append("NO\n");

        }
        System.out.println(sb);
    }
}
