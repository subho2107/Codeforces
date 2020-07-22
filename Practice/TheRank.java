import java.io.*;
import java.util.*;

public class TheRank {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp;
        Integer[]arr = new Integer[n];
        for (int pos = 0; pos < n; pos++) {
            inp = buffer.readLine().split(" ");
            arr[pos]  = Integer.parseInt(inp[0])+Integer.parseInt(inp[1])+Integer.parseInt(inp[2])+Integer.parseInt(inp[3]);
        }
        int thomasSore = arr[0];
        Arrays.sort(arr);
        int pos = Arrays.binarySearch(arr, thomasSore);
        while (pos < n && arr[pos]==thomasSore)pos++;
        pos--;
        sb.append(n-pos);
        System.out.println(sb);
    }
}
