import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BallsOfSteel {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            ArrayList<int []> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                inp = buffer.readLine().split(" ");
                int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
                points.add(new int[]{x, y});
            }
            int operations = 0;
            boolean check = true;
            while(check){
                check = false;
                n = points.size();
                int maxCnt = 0, maxCntBall = -1;
                for (int i = 0; i < n; i++) {
                    int cnt = 0;
                    int x = points.get(i)[0], y = points.get(i)[1];
                    for (int j = 0; j < n; j++) {
                        if (i == j)continue;
                        int x1 = points.get(j)[0], y1 = points.get(j)[1];
                        if (Math.abs(x - x1)+Math.abs(y - y1) <= k)
                            cnt++;
                    }
                    if (cnt > maxCnt){
                        maxCnt = cnt;
                        maxCntBall = i;
                    }
                }
                if (maxCnt != 0){
                    check = true;
                    int x = points.get(maxCntBall)[0], y = points.get(maxCntBall)[1];
                    for (int i = n-1; i >= 0; i--) {
                        if (i == maxCntBall)continue;
                        int x1 = points.get(i)[0], y1 = points.get(i)[1];
                        if (Math.abs(x - x1)+Math.abs(y - y1) <= k)
                          points.remove(i);
                    }
                    operations++;
                }
            }
            if (points.size() == 1)
                sb.append(operations+"\n");
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
