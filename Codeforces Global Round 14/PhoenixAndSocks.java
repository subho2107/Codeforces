import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoenixAndSocks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), l = Integer.parseInt(inp[1]), r = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer> socks = new HashMap<>();
            for (int i = 0; i < l; i++) {
                int colour = Integer.parseInt(inp[i]);
                socks.put(colour, socks.getOrDefault(colour, 0) + 1);
            }
            for (int i = 0; i < r; i++) {
                int colour = Integer.parseInt(inp[i + l]);
                socks.put(colour, socks.getOrDefault(colour, 0) - 1);
            }
            long cost = 0;
            int left = 0, right = 0;
            for (int colour : socks.keySet()) {
                int cnt = Math.abs(socks.get(colour));
                if (cnt == 0)
                    continue;
                int sign = socks.get(colour) / cnt;
                if (sign > 0)
                    left += cnt;
                else
                    right += cnt;
            }
            if (left != right) {
                left = 0;
                right = 0;
                for (int colour : socks.keySet()) {
                    int cnt = Math.abs(socks.get(colour));
                    if (cnt == 0)
                        continue;
                    cost += cnt / 2;
                    if (cnt % 2 != 0) {
                        int sign = socks.get(colour) / cnt;
                        socks.put(colour, sign);
                        if (sign > 0)
                            left++;
                        else
                            right++;
                    }
                }
            }
            if (left != 0 && right != 0) {
                int min = Math.min(left, right);
                cost += min;
                left -= min;
                right -= min;
            }
            cost += left + right;
            sb.append(cost).append("\n");

        }
        System.out.println(sb);
    }
}
