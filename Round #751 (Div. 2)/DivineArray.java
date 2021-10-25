import java.io.*;
import java.util.*;

public class DivineArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int [] dup = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                dup[i] = arr[i];
            }
            List<int[]>list = new ArrayList<>();
            list.add(dup);
            HashMap<Integer, Integer>freq;
            while (true){
                dup =  new int[n];
                freq = new HashMap<>();
                for (int i : arr) {
                    freq.put(i, freq.getOrDefault(i, 0)+1);
                }
                boolean check = true;
                for (int i = 0; i < n; i++) {
                    dup[i] = freq.get(arr[i]);
                    if (arr[i] != dup[i])
                        check = false;
                    arr[i] = dup[i];
                }
                if (check) {
                    break;
                }
                list.add(dup);
            }
            int q = Integer.parseInt(buffer.readLine());
            for (int i = 0; i < q; i++) {
                inp = buffer.readLine().split(" ");
                int xi = Integer.parseInt(inp[0])-1, ki = Integer.parseInt(inp[1]), ans = -1;
                if (ki >= list.size())
                    ans = list.get(list.size()-1)[xi];
                else
                    ans = list.get(ki)[xi];
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
}
