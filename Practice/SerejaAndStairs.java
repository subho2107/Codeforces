import java.io.*;
import java.util.*;

public class SerejaAndStairs {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int cnt = 0;
            HashMap<Integer, Integer>freq = new HashMap<>();
            int max = 0;
            for (int pos = 0; pos < n; pos++) {
                int num = Integer.parseInt(inp[pos]);
                freq.put(num, freq.getOrDefault(num, 0)+1);
                max = Math.max(num, max);
            }
            ArrayList<Integer>nums = new ArrayList<>(freq.keySet());
            nums.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int num:freq.keySet()){
                if (num==max)
                {
                    cnt++;
                    continue;
                }
                cnt+= Math.min(freq.get(num), 2);
            }
            sb.append(cnt+"\n");
            for (int pos = 0; pos < nums.size() - 1; pos++) {
                sb.append(nums.get(pos)+" ");
                freq.put(nums.get(pos), freq.get(nums.get(pos))-1);
            }
            sb.append(nums.get(nums.size()-1)+" ");
            for (int pos = nums.size()-2; pos >= 0; pos--) {
                if (freq.get(nums.get(pos))!=0)
                    sb.append(nums.get(pos)+" ");
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
