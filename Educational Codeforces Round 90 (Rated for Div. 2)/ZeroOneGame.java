import java.io.*;
import java.util.*;

public class ZeroOneGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String s = buffer.readLine();
            int cnt = 0;

            while (!s.equals(""))
            {
                boolean check = false;
                for (int pos = 0; pos < s.length() - 1; pos++) {
                    if (s.charAt(pos)!=s.charAt(pos+1))
                    {
                        check = true;
                        s = s.substring(0, pos)+s.substring(pos+2);
                        cnt++;
                        break;
                    }

                }
                if (!check)
                    break;
            }
            if (cnt%2==1)
                sb.append("DA\n");
            else
                sb.append("NET\n");
        }
        System.out.println(sb);
    }
}
