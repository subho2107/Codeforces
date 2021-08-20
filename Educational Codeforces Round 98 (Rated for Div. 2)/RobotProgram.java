import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RobotProgram {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
            if (x == y)
                sb.append(2*x);
            else
                sb.append(2* Math.min(x,y)+2*Math.abs(x-y)-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
