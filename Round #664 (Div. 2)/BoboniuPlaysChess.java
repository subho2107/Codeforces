import java.io.*;
import java.util.*;

public class BoboniuPlaysChess {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), x = Integer.parseInt(inp[2]), y = Integer.parseInt(inp[3]);
            for (int i = y; i <= m; i++) {
                sb.append(x+" "+i+"\n");
            }
            for (int i = y-1; i >= 1; i--) {
                sb.append(x+" "+i+"\n");
            }
            int turn = 0;
            for (int row = x-1; row >=1 ; row--) {
                if (turn==0){
                    for (int col = 1; col <= m; col++) {
                        sb.append(row+" "+col+"\n");
                    }
                }
                else {
                    for (int col = m; col >=1 ; col--) {
                        sb.append(row+" "+col+"\n");
                    }
                }
                turn ^=1;
            }
            for (int row = x+1; row <=n ; row++) {
                if (turn==0){
                    for (int col = 1; col <= m; col++) {
                        sb.append(row+" "+col+"\n");
                    }
                }
                else {
                    for (int col = m; col >=1 ; col--) {
                        sb.append(row+" "+col+"\n");
                    }
                }
                turn ^=1;
            }

        }
        System.out.println(sb);
    }
}
