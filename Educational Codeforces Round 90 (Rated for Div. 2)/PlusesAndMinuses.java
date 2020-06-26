import java.io.*;
import java.util.*;

public class PlusesAndMinuses {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] arr = buffer.readLine().toCharArray();
            HashMap<Long, Integer> negative = new HashMap<Long, Integer>();
            long a = 0;
            for (int pos = 0; pos < arr.length; pos++) {
                if (arr[pos]=='-')
                    a--;
                else
                    a++;
                if (a<0) {
                    negative.putIfAbsent(-a, pos);
                }
            }
            long  cnt = 0;
            for (long num :
                    negative.keySet()) {
                cnt += negative.get(num)+1;
            }
            cnt += arr.length;
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
