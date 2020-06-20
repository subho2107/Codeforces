import java.io.*;
import java.util.*;

public class GCD_Compression {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int len = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            ArrayList<Integer>odd=new ArrayList<Integer>();
            ArrayList<Integer>even=new ArrayList<Integer>();
            for (int pos = 0; pos < 2*len; pos++) {
                if (Integer.parseInt(inp[pos])%2==0)even.add(pos+1);
                else odd.add(pos+1);
            }
            if (odd.size()%2!=0)
            {
                odd.remove(0);
                even.remove(0);
            }
            else
            {
                if (odd.size()>=2)
                {
                    odd.remove(0);
                    odd.remove(0);
                }
                else
                {
                    even.remove(0);
                    even.remove(0);
                }
            }
            while(even.size()!=0)
                sb.append(even.remove(0)+" "+even.remove(0)+"\n");
            while (odd.size()!=0)
                sb.append(odd.remove(0)+" "+odd.remove(0)+"\n");
        }
        System.out.println(sb);
    }
}
