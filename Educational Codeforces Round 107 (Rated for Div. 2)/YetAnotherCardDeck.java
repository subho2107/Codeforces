import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class YetAnotherCardDeck {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            int[] colour = new int[n];
            HashMap<Integer, Integer>position = new HashMap<>();
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                colour[i] = Integer.parseInt(inp[i]);
                if (!position.containsKey(colour[i]))
                    position.put(colour[i], -1);
            }
            for (int i = 0; i < n; i++) {
                if (position.get(colour[i]) == -1)
                    position.put(colour[i], i+1);
            }
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < q; i++) {
                int currColour = Integer.parseInt(inp[i]);
                int currColPos = position.get(currColour);
                sb.append(currColPos+" ");
                for (int col : position.keySet()) {
                    if (position.get(col) < currColPos) {
                        position.put(col, position.get(col)+1);
                    }
                }
                position.put(currColour, 1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}