import java.io.*;
import java.util.*;

public class AddingNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int a = Integer.parseInt(inp[0]), b = Integer.parseInt(inp[1]), n = Integer.parseInt(inp[2]);
        int temp = a%b, lastDig;
        boolean check = false;
        for (lastDig = 0; lastDig < 10; lastDig++) {
            if ((temp*10+lastDig) % b==0)
            {
                check = true;
                break;
            }
        }
        if (!check)
            sb.append("-1\n");
        else {
            a = a*10+lastDig;
            int cnt = 1;
            sb.append(a);
            while(cnt++<n){
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
