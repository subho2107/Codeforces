import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloorNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), x = Integer.parseInt(inp[1]);
            int floor = 1;
            if (n <= 2)
                sb.append(1+"\n");
            else {
                long apt = 2;
                for (;n>apt;floor++,apt+=x){}
                sb.append(floor+"\n");
            }
        }
        System.out.println(sb);
    }
}
