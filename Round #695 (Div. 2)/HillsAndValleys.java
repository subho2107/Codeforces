import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HillsAndValleys {
    public static char isHillOrValley(int i, int[] arr) {
        if (i - 1 >= 0 && i + 1 < arr.length) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return 'H';
            else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                return 'V';
        }
        return ' ';
    }

    public static int getChanges(int i, int k, int[] arr, char[] hillOrValley) {
        int dup = arr[i];
        arr[i] = arr[k];
        int changedEffectively = 0;
        for (int j = i - 1; j <= i + 1; j++) {
            char temp = isHillOrValley(j, arr);
            if (temp == ' ' && hillOrValley[j] != ' ')
                changedEffectively++;
            else if (temp != ' ' && hillOrValley[j] == ' ')
                changedEffectively--;
        }
        arr[i] = dup;
        return changedEffectively;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            char[] hillOrValley = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int intitmidation = 0;
            for (int i = 0; i < n; i++) {
                hillOrValley[i] = isHillOrValley(i, arr);
                if (hillOrValley[i] != ' ')
                    intitmidation++;
            }
            if (intitmidation == 0){
                sb.append(0+"\n");
                continue;
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                if (hillOrValley[i] != ' ') {
                    ans = Math.max(ans, Math.max(getChanges(i, i + 1, arr, hillOrValley), getChanges(i, i - 1, arr, hillOrValley)));
                }
            }
            sb.append(intitmidation-ans).append("\n");
        }
        System.out.println(sb);
    }
}
