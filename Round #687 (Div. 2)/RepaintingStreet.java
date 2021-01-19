import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepaintingStreet {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] colour = new int[n];
            int [] freq = new int[101];
            for (int i = 0; i < n; i++) {
                colour[i] = Integer.parseInt(inp[i]);
                freq[colour[i]]++;
            }
            int ans = Integer.MAX_VALUE;
            for (int currColour = 1; currColour <= 100; currColour++) {
                int day = 0, dup = freq[currColour];
                if (dup == 0)
                    continue;
                for (int i = 0; i < n && dup < n; i++) {
                    if (colour[i] == currColour) continue;
                    day++;
                    for (int j = 0; j < k && i + j < n; j++) {
                        if (colour[i + j] != currColour) {
                            dup++;
                        }
                    }
                    i += k - 1;
                }
                ans = Math.min(ans, day);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
