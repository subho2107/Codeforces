import java.io.*;
import java.util.*;

class CommonPrefixes {
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(bu.readLine());
            String [] inp = bu.readLine().split(" ");
            int [] arr = new int[n+1];
            for (int pos = 1; pos <= n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos-1]);
            }
            String prev = "";
            char ch = 'a';
            for (int pos = 1; pos < n + 1; pos++) {
                String curr = "";
                for (int pos2 = 0; pos2 < arr[pos - 1]; pos2++) {
                    curr += prev.charAt(pos2);
                }
                for (int pos2 = 0; pos2 < arr[pos]-arr[pos-1]; pos2++) {
                    curr+=ch;
                }
                if (curr.equals(""))
                    curr +=ch;
                ch++;
                if (ch=='z')
                    ch = 'a';
                prev = curr;
                sb.append(curr+"\n");
            }
            if (arr[arr.length - 1]!=0) {
                for (int pos = 0; pos < arr[arr.length - 1]; pos++) {
                    sb.append(prev.charAt(pos));
                }
            }
            else sb.append((char)(ch+1));

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
