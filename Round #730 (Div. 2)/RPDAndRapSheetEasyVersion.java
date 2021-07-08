import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RPDAndRapSheetEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), r = 0;
            for (int i = 0; i < n; i++) {
                int prev = i == 0?0:i-1;
                System.out.println(prev^i);
                System.out.flush();
                r = Integer.parseInt(buffer.readLine());
                if (r == 0)
                    continue;
                else if (r == 1)
                    break;
                else
                    return;
            }
            if (r == 0)
                return;
        }
        System.out.println(sb);
    }
}
