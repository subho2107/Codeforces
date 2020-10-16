import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ChessCheater {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            char[] matches = buffer.readLine().toCharArray();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int loss, win = 0, winStreak = 0;
            for (int i = 0; i < n; i++) {
                if (matches[i] == 'W') {
                    win++;
                    if (i == 0 || matches[i - 1] == 'L')
                        winStreak++;
                } else {
                    if (i == 0 || matches[i - 1] == 'W') arrayList.add(0);

                    arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) + 1);
                }
            }
            loss = n - win;
            if (loss <= k) {
                sb.append(2 * n - 1).append("\n");
                continue;
            }
            if (win == 0) {
                if (k == 0)
                    sb.append(0 + "\n");
                else
                    sb.append(2 * k - 1).append("\n");
                continue;
            }
            if (matches[n - 1] == 'L')
                arrayList.set(arrayList.size() - 1, Integer.MAX_VALUE);
            if (matches[0] == 'L')
                arrayList.set(0, Integer.MAX_VALUE);
            Collections.sort(arrayList);
            win += k;
            int score;
            for (int gap : arrayList) {
                if (gap > k) break;
                winStreak--;
                k -= gap;
            }
            score = 2 * win - winStreak;
            sb.append(score + "\n");
        }
        System.out.println(sb);
    }
}
