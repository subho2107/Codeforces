import java.io.*;
import java.util.*;

public class ArrayDestruction {
    public static HashMap<Integer, Integer> reduceFreq(HashMap<Integer, Integer>hashMap, int val){
        if (!hashMap.containsKey(val))
            return hashMap;
        if (hashMap.get(val) == 1)
            hashMap.remove(val);
        else
            hashMap.put(val, hashMap.get(val)-1);
        return hashMap;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[2 * n];
            HashMap<Integer, Integer> freq = new HashMap<>();
            int x = 0;
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }
            Arrays.sort(arr);
            boolean check = false;
            for (int num : freq.keySet()) {
                HashMap<Integer, Integer>temp = new HashMap<>(freq);
                int tempX = arr[2*n-1]+num, maxPos = arr.length-1;
                ArrayList<int []>operations = new ArrayList<>();
                while (temp.size() != 0){
                    while (maxPos >= 0 && !temp.containsKey(arr[maxPos]))
                        maxPos--;
                    if(maxPos<0)
                        break;
                    temp = reduceFreq(temp, arr[maxPos]);
                    if (!temp.containsKey(tempX-arr[maxPos])) {
                        temp.put(arr[maxPos], temp.getOrDefault(arr[maxPos], 0)+1);
                        break;
                    }
                    operations.add(new int[]{tempX-arr[maxPos], arr[maxPos]});
                    temp = reduceFreq(temp, tempX-arr[maxPos]);
                    tempX = arr[maxPos];
                }
                if (temp.size() != 0)
                    continue;
                check = true;
                sb.append("YES\n");
                sb.append(num+arr[2*n-1]).append("\n");
                for (int[] operation : operations)
                    sb.append(operation[0]).append(" ").append(operation[1]).append("\n");
                break;
            }
            if (!check)
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
