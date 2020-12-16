import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class DivideAndSummarize {
    static HashSet<Long> possibleSums;
    public static void generateAllSequences(int left, int right, int[] arr) {
        long sum = 0;
        int pos = -1;
        int mid = (arr[left] + arr[right]) / 2;
        for (int i = left; i < right + 1; i++) {
            sum += arr[i];
            if (arr[i] <= mid)
                pos = i;
        }
        possibleSums.add(sum);
        if (pos < 0 || pos > arr.length ||left ==right||pos==right)
            return;
        if (pos >= left)
        generateAllSequences(left, pos, arr);
        if (pos + 1 <= right)
            generateAllSequences(pos + 1, right, arr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            possibleSums = new HashSet<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inp[i]);
            Arrays.sort(arr);
            generateAllSequences(0, n - 1, arr);
            for (int query = 0; query < q; query++) {
                long target = Integer.parseInt(buffer.readLine());
                if (possibleSums.contains(target))
                    sb.append("Yes\n");
                else
                    sb.append("No\n");
            }
        }
        System.out.println(sb);
    }
}
