import java.io.*;
import java.util.*;

public class ZeroRemainderArray {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            HashMap<Integer, Integer>freqOfRems = new HashMap<>();
            for (int pos = 0; pos < n; pos++) {
                int temp = Integer.parseInt(inp[pos]);
                if (temp%k==0)continue;
                temp = k-temp%k;
                freqOfRems.put(temp,freqOfRems.getOrDefault(temp,0)+1);
            }
            if (freqOfRems.size()==0)
            {
                sb.append("0\n");
                continue;
            }
            long maxVal = 0;
            for (int rem :
                    freqOfRems.keySet()) {
                long temp = rem + (long)(freqOfRems.get(rem)-1)*k;
                maxVal = Math.max(maxVal, temp);
            }

            sb.append(maxVal+1+"\n");
        }
        System.out.println(sb);
    }
}
