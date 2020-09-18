import java.io.*;
import java.util.*;

public class MultiplesOfLength {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        long [] arr = new long[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        if (n == 1){
            System.out.println("1 1");
            System.out.println(-arr[0]);
            for (int pos = 0; pos < 2; pos++) {
                System.out.println("1 1");
                System.out.println(0);
            }
        }
        else {
            System.out.println("1 1");
            System.out.println(-arr[0]);
            System.out.println("1 "+n);
            System.out.print(0+" ");
            for (int pos = 1; pos < n; pos++) {
                long num = -arr[pos]*n;
                System.out.print(num+" ");
            }
            System.out.println();
            System.out.println("2 "+n);
            for (int pos = 1; pos < n; pos++) {
                long num = (n-1)*arr[pos];
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
