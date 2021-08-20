import java.io.*;
import java.util.*;

 class EEE {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            if (n < 3) {
                sb.append(0 + "\n");
                for (int pos = 0; pos < n; pos++) {
                    sb.append(arr[pos] + " ");
                }
                sb.append("\n");
                continue;
            }
            Arrays.sort(arr);
            int lo = 0, high = n + 1;
            while (lo + 1 < high) {
                int mid = (lo + high) / 2;
                boolean isPoss = true;
                if (2 * mid + 1 > n) {
                    isPoss = false;
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    int posA = 0, posB = n - (mid + 1);
                    for (int pos = 0; pos < 2 * mid + 1; pos++) {
                        if (pos % 2 == 0){
                            integers.add(arr[posB]);
                            posB++;
                        }
                        else{
                            integers.add(arr[posA]);
                            posA++;
                        }
                    }
                    for (int pos = 1; pos < integers.size(); pos+=2) {

                    }
                }
                if (isPoss)
                    lo = mid;
                else
                    high = mid;
            }
            sb.append(lo + "\n");
            HashSet<Integer> addedPos = new HashSet<>();
            for (int pos = 0; pos < lo; pos++) {
                sb.append(arr[n - pos - 1] + " " + arr[pos] + " ");
                addedPos.add(n - pos - 1);
                addedPos.add(pos);
            }
            for (int pos = 0; pos < n; pos++) {
                if (addedPos.add(pos))
                    sb.append(arr[pos] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
