import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BoxFitting {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), w = Integer.parseInt(inp[1]);
            TreeMap<Integer, Integer>rectangles = new TreeMap<>((o1, o2) -> o2 - o1);
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int width = Integer.parseInt(inp[i]);
                rectangles.put(width, rectangles.getOrDefault(width, 0)+1);
            }
            int ans = 0;
            while (true){
                long currWidth = 0;
                for (int width : rectangles.keySet()) {
                    if (rectangles.get(width) == 0)continue;
                    if (currWidth + width > w)
                        break;
                    currWidth += width;
                    rectangles.put(width, rectangles.get(width)-1);
                }
                if (currWidth == 0)
                    break;
                ans++;
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
