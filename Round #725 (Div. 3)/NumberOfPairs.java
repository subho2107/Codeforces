import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//taken from https://www.geeksforgeeks.org/queries-counts-array-elements-values-given-range/
public class NumberOfPairs {
    static int lowerIndex(Integer[] arr, int start, int n, int x)
    {
        int l = start, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    static int upperIndex(Integer[] arr, int start, int n, int y)
    {
        int l = start, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), l= Integer.parseInt(inp[1]), r = Integer.parseInt(inp[2]);
            Integer[] arr = new Integer[n];
            inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(arr);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > r)
                    continue;
                int li = l-arr[i], ri = r-arr[i];
                ans += upperIndex(arr,i+1, n, ri)-lowerIndex(arr, i+1, n, li)+1;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
