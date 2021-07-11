import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShortestPathWithObstacle {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String temp = buffer.readLine();
            if (temp.length() == 0) {
                t++;
                continue;
            }
            String [] inp = temp.split(" ");
            int xA = Integer.parseInt(inp[0]), yA = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int xB = Integer.parseInt(inp[0]), yB = Integer.parseInt(inp[1]);
            inp =buffer.readLine().split(" ");
            int xF = Integer.parseInt(inp[0]), yF = Integer.parseInt(inp[1]);
            int ans = 0;
            if (xA == xB && yA == yB)
                ans = 0;
            else if(xA == xB){
                ans = Math.abs(yA - yB);
                int min = Math.min(yA, yB), max = Math.max(yA, yB);
                if (xF == xA && yF >= min && yF <= max)
                    ans += 2;
            }
            else if (yA == yB){
                ans = Math.abs(xA - xB);
                int min = Math.min(xA, xB), max = Math.max(xA, xB);
                if (yF == yA && xF >= min && xF <= max)
                    ans+= 2;
            }
            else{
                ans = Math.abs(xA - xB)+ Math.abs(yA - yB);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
