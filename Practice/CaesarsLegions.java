import java.io.*;
import java.util.*;

public class CaesarsLegions {
    static int[][][][] dp = new int[101][101][11][11];
    static int MOD = 100000000;
    static int limitA, limitB;
    public static int getCnt(int n1, int n2, int k1, int k2) {
        if ((n1 + n2) == 0) return 1;
        if (dp[n1][n2][k1][k2]!=-1)return dp[n1][n2][k1][k2];
        int a = 0, b = 0;
        if (n1 >= 1 && k1 >= 1)
            a = getCnt(n1 - 1, n2, k1 - 1, limitB)%MOD;
        if (n2 >= 1 && k2 >= 1)
            b = getCnt(n1, n2 - 1, limitA, k2 - 1)%MOD;
        return dp[n1][n2][k1][k2] = (a+b)%MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        String [] inp = buffer.readLine().split(" ");
        int n1 = Integer.parseInt(inp[0]), n2 = Integer.parseInt(inp[1]), k1 = Integer.parseInt(inp[2]), k2 = Integer.parseInt(inp[3]);
        limitA = k1; limitB = k2;
        System.out.println(getCnt(n1, n2, k1, k2)%MOD);
    }
}
