import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BigVova {
    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int maxNum = -1;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                maxNum = Math.max(maxNum, arr[pos]);
            }
            ArrayList<Integer>ans = new ArrayList<>();
            ans.add(maxNum);
            HashSet<Integer>used = new HashSet<>();
            used.add(n-1);
            Arrays.sort(arr);
            int prevGCD = maxNum;
            for (int i = 0; i < n-1; i++) {
                int maxGCD = -1, currMaxPos = -1;
                for (int j = 0; j < n; j++) {
                    if (used.contains(j))continue;
                    int currGCD = gcd(prevGCD, arr[j]);
                    if (currGCD > maxGCD){
                        maxGCD = currGCD;
                        currMaxPos = j;
                    }
                }
                used.add(currMaxPos);
                ans.add(arr[currMaxPos]);
                prevGCD = maxGCD;
            }
            for (Integer an : ans) {
                sb.append(an+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
