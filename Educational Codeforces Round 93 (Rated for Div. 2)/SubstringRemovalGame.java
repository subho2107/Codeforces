import java.io.*;
import java.util.*;

public class SubstringRemovalGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String inp = buffer.readLine();
            int n;
            int alice = 0, other = 0, turn = 0;
            while(inp.indexOf('1')!=-1){
                n = inp.length();
                int j = 0, maxLen = Integer.MIN_VALUE, pos = 0;
                for (int i = 0; i < n; i++) {
                    for (j = i; j < n; j++) {
                        if (inp.charAt(j)=='0')
                            break;
                    }
                    if (j-i>maxLen){
                        pos = i;
                        maxLen = j-i;
                    }
                }
                if (turn==0){
                    alice += maxLen;
                }
                else {
                    other += maxLen;
                }
                inp = inp.substring(0, pos)+inp.substring(pos+maxLen);
                turn^=1;
            }
            sb.append(alice+"\n");
        }
        System.out.println(sb);
    }
}
