import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircleGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int d = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int x = 0, y = 0;
            long target = (long)d*d;
            int turn = 0;
            while (true){
                long val = (long)x*x + (long)y*y;
                if (val>target)
                    break;
                int minVal = Math.min(x, y), maxVal = Math.max(x, y)+k;
                long temp = (long)(minVal+k)*(minVal+k) + (long)maxVal*maxVal, temp2 = (long)minVal*minVal + (long)(maxVal+k)*(maxVal+k);
                long a = (long)minVal*minVal + (long)maxVal*maxVal;
                if (a <= target && (temp > target && temp2 > target))
                {
                    if (x == maxVal-k)
                        x=maxVal;
                    else
                        y = maxVal;
                }
                else
                {
                    if (x == minVal)
                        x+=k;
                    else
                        y+=k;
                }
                turn^=1;
            }
            if (turn == 0){
                sb.append("Ashish\n");
            }
            else
                sb.append("Utkarsh\n");
        }
        System.out.println(sb);
    }
}
