import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BovineDilemma {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int x1 = 0, y1 = 1,y3 = 0, y2 = 0;
            HashSet<Float>areas = new HashSet<>();
            for (int x2 = 0; x2 < n; x2++) {
                for (int x3 = x1+1; x3 < n; x3++) {
                    float area = Math.abs((float) (0.5*(arr[x2] * (y3 - y1) + arr[x3] * (y1 - y2))));
                    if (area == 0)continue;
                    areas.add(area);
                }
            }
            sb.append(areas.size()).append("\n");
        }
        System.out.println(sb);
    }
}
