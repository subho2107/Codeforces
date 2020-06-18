import java.io.*;
import java.util.*;

public class Even_Picture {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        int row = 0, col = 0;
        int cnt= 0;
        sb.append("0 0\n");
        for (int pos = 0; pos <= n; pos++) {
            sb.append((row+1)+" "+col+"\n");
            sb.append(row+" "+(col+1)+"\n");
            sb.append((row+1)+" "+(col+1)+"\n");
            row++;col++;
            cnt+=3;
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
