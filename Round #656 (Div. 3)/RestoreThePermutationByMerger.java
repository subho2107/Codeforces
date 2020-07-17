import java.io.*;
import java.util.*;

public class RestoreThePermutationByMerger {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            Set<Integer> a = new HashSet<>();
            ArrayList<Integer> b = new ArrayList<>();
            for (int pos = 0; pos < inp.length; pos++) {
                if (a.add(Integer.parseInt(inp[pos])))
                    b.add(Integer.parseInt(inp[pos]));
            }
            for (int num :
                    b) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
