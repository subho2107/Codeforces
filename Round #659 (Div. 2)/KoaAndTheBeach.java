import java.io.*;
import java.util.*;

public class KoaAndTheBeach {
    public static void main(String[] args) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] inp = bu.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), l = Integer.parseInt(inp[2]);
            int [] depths = new int[n+1];
            inp = bu.readLine().split(" ");
            boolean check = true;
            ArrayList<Integer>safePositions = new ArrayList<>();
            safePositions.add(0);
            for (int pos = 1; pos <= n; pos++) {
                int num = Integer.parseInt(inp[pos-1]);
                depths[pos] = num;
                if (num+k<=l)
                    safePositions.add(pos);
            }
            safePositions.add(n+1);
            for (int safePos = 1; safePos < safePositions.size()&& check; safePos++) {
                int tide = k;
                boolean down = true;
                for (int unsafePos = safePositions.get(safePos-1)+1; unsafePos < safePositions.get(safePos) ; unsafePos++) {
                    tide += down?-1:+1;
                    if (down)tide-=Math.max(0, depths[unsafePos]+tide-l);
                    if (tide<0||tide+depths[unsafePos]>l){
                        check = false;
                        break;
                    }
                    if (tide==0)down = false;
                }
            }

            if (check)
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.print(sb);
    }
}
