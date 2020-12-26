import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedBlueShuffle {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] freqA = new int[n];
            int [] freqB = new int[n];
            char [] inp = buffer.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                int num = Character.getNumericValue(inp[i]);
                freqA[i] = num;
            }
            inp = buffer.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                int num = Character.getNumericValue(inp[i]);
                freqB[i] = num;
            }
            int red = 0, blue = 0;
            for (int i = 0; i < n; i++) {
                if (freqA[i] > freqB[i])
                    red++;
                else if (freqA[i] < freqB[i])
                    blue++;
            }
            if (red > blue)
                sb.append("RED\n");
            else if (blue > red)
                sb.append("BLUE\n");
            else
                sb.append("EQUAL\n");
        }
        System.out.println(sb);
    }
}
