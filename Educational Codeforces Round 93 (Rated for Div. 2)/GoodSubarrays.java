import java.io.*;
import java.util.*;

public class GoodSubarrays {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char []s = buffer.readLine().toCharArray();
            int [] arr = new int[n+1];
            for (int pos = 1; pos <= n; pos++) {
                arr[pos] = Character.getNumericValue(s[pos-1])-1;
            }
            int [] prefSum = new int[n+1];
            HashMap<Integer, Integer>groupSums = new HashMap<>();
            groupSums.put(0, 1);
            for (int i = 1; i <= s.length; i++) {
                prefSum[i] = prefSum[i-1]+arr[i];
                groupSums.put(prefSum[i], groupSums.getOrDefault(prefSum[i], 0)+1);
            }
            long goodSubArrays = 0;
            for (int sum:groupSums.keySet()){
                long freq = groupSums.get(sum);
                goodSubArrays += freq*(freq-1)/2;//nC2
            }
            sb.append(goodSubArrays+"\n");
        }
        System.out.println(sb);
    }
}
