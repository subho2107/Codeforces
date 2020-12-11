import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ApplemanAndCardGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
        String s = buffer.readLine();
        int [] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        long ans = 0;
        for (int i = 25, j = 0; i >= 0 && j < k ; i--) {
            int rem = Math.min(k - j, freq[i]);
            ans += (long) rem * rem;
            j += freq[i];
        }
        System.out.println(ans);
    }
}
