import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), c0 = Integer.parseInt(inp[1]), c1 = Integer.parseInt(inp[2]), h = Integer.parseInt(inp[3]);
            String s = buffer.readLine();
            int one = 0, zero = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1')
                    one++;
                else
                    zero++;
            }
            long cost = (long)c0*zero+(long)c1*one;
            if (c0 < c1){
                long tempCost = cost;
                while (one > 0 && tempCost-c1+(c0+h)<tempCost){
                    tempCost = tempCost-c1+(c0+h);
                    one--;
                }
                cost = Math.min(cost, tempCost);
            }
            else {
                long tempCost = cost;
                while (zero > 0 && tempCost-c0+(c1+h)<tempCost){
                    tempCost = tempCost-c0+(c1+h);
                    zero--;
                }
                cost = Math.min(cost, tempCost);
            }
            sb.append(cost+"\n");
        }
        System.out.println(sb);
    }
}
