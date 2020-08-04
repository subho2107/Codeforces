import java.io.*;
import java.util.*;

public class SerejaAndBottles {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int [] arrA = new int[n];
        int [] arrB = new int[n];
        for (int pos = 0; pos < n; pos++) {
            String[] inp = buffer.readLine().split(" ");
            int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]);
            arrA[pos] = a;
            arrB[pos] = b;
        }
        int cnt = 0;
        Set<Integer>visited = new HashSet<>();
        for (int pos = 0; pos < n; pos++) {
            for (int pos2 = 0; pos2 < n; pos2++) {
                if (arrA[pos]==arrB[pos2] && pos!=pos2 && !visited.contains(pos)) {
                    cnt++;
                    visited.add(pos);
                }
            }
        }
        System.out.println(n-cnt);

    }
}
