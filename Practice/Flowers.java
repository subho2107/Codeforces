import java.io.*;
import java.util.*;

public class Flowers {
    static int k, MOD = 1000000007 ;
    static int [] dp;
    static int [] prefix;
    public static int getDeliciousCnt(int len){
        int val = 0;
        if (len==0)return  1;
        if (dp[len]!=-1)return dp[len];
        val += getDeliciousCnt(len-1)%MOD;
        if (len-k>=0)
            val += getDeliciousCnt(len-k)%MOD;
        return dp[len]=val;
    }
    public static void init(){
        prefix = new int[100001];
        for (int i = 1; i <= 100000 ; i++) {
            prefix[i] = (prefix[i-1]%MOD+getDeliciousCnt(i)%MOD)%MOD;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int t = Integer.parseInt(inp[0]);
        k = Integer.parseInt(inp[1]);
        dp = new int[100001];
        Arrays.fill(dp, -1);
        init();
        while (t-- > 0) {
            inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            int sum = (prefix[b]-prefix[a-1]+MOD)%MOD;
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
