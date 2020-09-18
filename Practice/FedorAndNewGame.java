import java.io.*;
import java.util.*;

public class FedorAndNewGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), k = Integer.parseInt(inp[2]);
        int cnt = 0;
        int [] arr = new int[m+1];
        for (int pos = 0; pos < m+1; pos++) {
            int x = Integer.parseInt(buffer.readLine());
            arr[pos] = x;
        }
        int fedorArmy = arr[m];
        for (int pos = 0; pos < m; pos++) {
            int xor = fedorArmy^arr[pos];
            int tempCnt = 0;
            for (int bit = 0; bit <= 31; bit++) {
                if (((xor>>bit)&1)!=0)
                    tempCnt++;
            }
            if (tempCnt <= k)
                cnt++;
        }
        System.out.println(cnt);
    }
}
