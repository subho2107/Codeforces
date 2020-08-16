import java.io.*;
import java.util.*;

public class FixYou {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split( " ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
//            char [][] matrix = new char[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                char [] s = buffer.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (i==n-1){
                        if (s[j]=='D')
                            cnt++;
                    }
                    else if (j==m-1){
                        if (s[j]=='R')
                            cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
