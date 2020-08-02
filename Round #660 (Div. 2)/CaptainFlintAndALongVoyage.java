import java.io.*;
import java.util.*;

public class CaptainFlintAndALongVoyage {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int temp = n/4;
            String res = "";
            for (int pos = 0; pos < temp; pos++) {
                res+='8';
            }
            if (n%4!=0)
                res+='8';
            else
                res+='9';
            for (int pos = 0; res.length()<n; pos++) {
                res+='9';
            }
            for (int i = 0; i < res.length(); i++) {
                sb.append(res.charAt(res.length() - i - 1));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
