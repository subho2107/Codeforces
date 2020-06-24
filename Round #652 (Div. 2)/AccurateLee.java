import java.io.*;
import java.util.*;

public class AccurateLee {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            int first1Pos = -1, last10Pos = -1, last0Pos = -1;
            for (int pos = 0; pos < n - 1; pos++) {
                if (s.charAt(pos)=='1')
                {
                    if (s.charAt(pos + 1) == '0')
                        last10Pos = pos;
                }
                if (s.charAt(pos)=='1' && first1Pos == -1)
                        first1Pos = pos;
                if (s.charAt(pos) == '0')
                        last0Pos = pos;
            }
            if (last10Pos == -1) {
                sb.append(s+"\n");
                continue;
            }

            if (s.charAt(s.length()-1)=='0')
                last0Pos = s.length()-1;

            String res = s.substring(0, first1Pos)+s.substring(last0Pos, s.length());
//            if (!res.equals("") && Integer.parseInt(res)==0)
//                res = "0";
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
}
