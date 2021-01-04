import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BearAndBigBrother {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        float limak = Integer.parseInt(inp[0]), bob = Integer.parseInt(inp[1]);
        int ans =  (int)(Math.log(bob/limak)/Math.log(1.5))+1;
        System.out.println(ans);
    }
}
