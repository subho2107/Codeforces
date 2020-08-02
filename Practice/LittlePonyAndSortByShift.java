import java.io.*;
import java.util.*;

public class LittlePonyAndSortByShift {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            ArrayList<Integer>arr = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                arr.add(Integer.parseInt(inp[pos]));
            }
            int pos = 0;
            for (; pos < n-1; pos++) {
                if (arr.get(pos) > arr.get(pos + 1))break;
            }
            pos++;
            int len = n-pos;
            boolean check = true;
            for (;pos<n-1;pos++){
                if (arr.get(pos)>arr.get(pos+1)){
                    check = false;
                    break;
                }
            }
            if ((check && arr.get(arr.size()-1)<=arr.get(0))||len==0)
                sb.append(len+"\n");
            else
                sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
