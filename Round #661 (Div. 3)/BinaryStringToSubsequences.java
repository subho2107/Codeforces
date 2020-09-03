import java.io.*;
import java.util.*;

public class BinaryStringToSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            TreeSet<Integer>set0 = new TreeSet<>(), set1 = new TreeSet<>();
            for (int pos = 0; pos < n; pos++) {
                if (s.charAt(pos)=='0')
                    set0.add(pos);
                else
                    set1.add(pos);
            }
            int [] ans = new int[n];
            int maxSize = 0;
            for (int pos = 0; set0.size() != 0 || set1.size() != 0; pos++) {
                maxSize = pos;
                if (set0.size() == 0 && set1.size() != 0){
                    int num = set1.iterator().next();
                    ans[num] = pos+1;
                    set1.remove(num);
                }
                else if (set1.size() == 0 && set0.size() != 0){
                    int num = set0.iterator().next();
                    ans[num] = pos+1;
                    set0.remove(num);
                }
                else {
                    Integer pos0 = set0.iterator().next(), pos1 = set1.iterator().next();
                    int turn = pos0 > pos1 ? 1:0;
                    while (pos0!=null && pos1!=null){
                        if (turn == 0){
                            set0.remove(pos0);
                            ans[pos0] = pos+1;
                            pos1 = set1.ceiling(pos0);
                        }else {
                            set1.remove(pos1);
                            ans[pos1] = pos+1;
                            pos0 = set0.ceiling(pos1);
                        }
                        turn^=1;
                    }
                }
            }
            sb.append(maxSize+1).append("\n");
            for (int pos = 0; pos < n; pos++) {
                sb.append(ans[pos]+" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
