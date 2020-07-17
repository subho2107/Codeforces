import java.io.*;
import java.util.*;

public class MahmoudAndLongestUncommonSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String a = buffer.readLine();
        String b = buffer.readLine();
        if (a.equals(b))
            sb.append(-1);
        else
        {
            int res = Math.max(a.length(), b.length());
            sb.append(res);
        }
        System.out.println(sb);
    }
}
