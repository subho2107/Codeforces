import java.io.*;
import java.util.*;

public class MagicalSticks {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(buffer.readLine());
            if (num%2==1)num++;
            sb.append( num/2+"\n");
        }
        System.out.println(sb);
    }
}
