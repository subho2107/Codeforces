import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WizardOfOz {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int i, j;
            for (i = 0,j = 9; i < n && j >= 8; i++, j--) {
                sb.append(j);
            }
            j = 9;
            for (;i < n; i++, j++){
                if (j == 10)
                    j = 0;
                sb.append(j);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
