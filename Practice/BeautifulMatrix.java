import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeautifulMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = 5, row = -1, col = -1;
        for (int i = 0; i < n; i++) {
            String [] inp = buffer.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(inp[j]);
                if (num == 1)
                {
                    col = j;
                    break;
                }
            }
            if (col != -1) {
                row = i;
                break;
            }
        }
        row++;
        col++;
        int ans = Math.abs(3-row)+Math.abs(3-col);
        System.out.println(ans);
    }
}
