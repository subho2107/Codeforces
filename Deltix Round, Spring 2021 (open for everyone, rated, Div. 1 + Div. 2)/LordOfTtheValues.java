import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LordOfTtheValues {
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
            int operations = 3*n;
            sb.append(operations+"\n");
            for (int i = 0; i < n; i+=2) {
                sb.append("1 "+(i+1)+" "+(i+2)).append("\n");
                sb.append("2 "+(i+1)+" "+(i+2)).append("\n");
                sb.append("1 "+(i+1)+" "+(i+2)).append("\n");
                sb.append("1 "+(i+1)+" "+(i+2)).append("\n");
                sb.append("2 "+(i+1)+" "+(i+2)).append("\n");
                sb.append("1 "+(i+1)+" "+(i+2)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
