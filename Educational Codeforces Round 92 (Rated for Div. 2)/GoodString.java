import java.io.*;
import java.util.*;

public class GoodString {
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String inp = bu.readLine();
            int res = 0;
            for (int a = '0'; a <= '9'; a++) {
                for (int b = '0'; b <= '9'; b++) {
                    int cnt = 0;
                    char c = (char) a, d = (char) b;
                    for (char ch:inp.toCharArray()){
                        if (ch==c) {
                            cnt++;
                            c = (char) (c^d^(d=c));
                        }
                    }
                    if (a==b)
                        res = Math.max(res, cnt);
                    else
                        res = Math.max(res, cnt&~1);
                }
            }
            sb.append(inp.length()-res+"\n");
        }
        System.out.print(sb);
    }
}
