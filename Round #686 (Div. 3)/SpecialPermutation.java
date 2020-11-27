import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialPermutation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            HashSet<Integer>hashSet = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                for (int j = n; j >= 1 ; j--) {
                    if (j != i && hashSet.add(j)) {
                        sb.append(j + " ");
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
