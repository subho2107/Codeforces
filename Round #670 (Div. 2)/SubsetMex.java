import java.io.*;
import java.util.*;

public class SubsetMex {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            boolean check = false;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if(arr[pos] == 0)
                    check = true;
            }
            if (!check){
                sb.append(0).append("\n");
                continue;
            }
            Arrays.sort(arr);
            ArrayList<Integer>a = new ArrayList<>(), b = new ArrayList<>();
            a.add(arr[0]);
            for (int pos = 1; pos < n; pos++) {
                if (arr[pos]-a.get(a.size()-1)==1)
                    a.add(arr[pos]);
                else
                    b.add(arr[pos]);
            }
            int mexA = 0, mexB = 0;
            int maxA = Collections.max(a), maxB =0;
            if (b.size()>=1)
                maxB =  Collections.max(b);
            mexA = maxA+1;
            HashSet<Integer>temp = new HashSet<>(b);
            for (int pos = 0; pos < maxB + 2; pos++) {
                if (!temp.contains(pos)){
                    mexB = pos;
                    break;
                }
            }
            sb.append(mexB+mexA).append("\n");
        }
        System.out.println(sb);
    }
}
