import java.io.*;
import java.util.*;

public class SortTheArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String[] inp = buffer.readLine().split(" ");
        int[] arr = new int[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        int pos = 0;
        while (pos < n-1 && arr[pos]<=arr[pos+1])
            pos++;
        if (pos==n-1){
            sb.append("yes\n");
            sb.append("1 1\n");
        }
        else {
            int startPos = pos;
            while (pos < n-1 && arr[pos]>=arr[pos+1])
                pos++;
            for (int i = 0; i < (pos-startPos+1) / 2; i++) {
                int aPos = i+startPos, bPos = pos-i;
                arr[aPos] = arr[bPos]^arr[aPos]^(arr[bPos]=arr[aPos]);
            }
            boolean check = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i]>arr[i+1]){
                    check = false;
                    break;
                }
            }
            if (!check)
                sb.append("no\n");
            else {
                sb.append("yes\n");
                sb.append(startPos + 1).append(" ").append(pos + 1).append("\n");
            }

        }
        System.out.println(sb);
    }
}
