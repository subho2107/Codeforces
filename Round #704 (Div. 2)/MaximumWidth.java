import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumWidth {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n  = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            String s = buffer.readLine();
            String s2 = buffer.readLine();
            int [] app = new int[m];
            app[0] = s.indexOf(s2.charAt(0));
            for (int i = 1; i < n; i++) {
                app[n-1] = s.lastIndexOf(s2.charAt(i));
            }
            for (int i = n-2; i >= 1; i--) {
                if (app[i+1] < app[i])
                    app[i] = app[i+1];
            }
            int j = 1;
            for (int i = 0; i < n; i++) {

            }

        }
        System.out.println(sb);
    }
}
