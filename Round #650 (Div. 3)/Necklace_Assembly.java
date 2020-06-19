import java.io.*;
import java.util.*;

public class Necklace_Assembly {
    public static void getFactors(int num, ArrayList<Integer>factors)
    {
        for (int fact = 1; fact <= (int) Math.sqrt(num); fact++)
        {
            if (num%fact==0)
            {
                factors.add(fact);
                if(num/fact!=fact)factors.add(num/fact);
            }
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int totalBeads = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), maxLen = 0;
            String beads = buffer.readLine();
            int[]frequency = new int[26];

            for (char ch : beads.toCharArray())
            {
                frequency[ch-'a']++;
            }
            ArrayList<Integer>factors = new ArrayList<Integer>();
            getFactors(k, factors);

            for (int partLength : factors)
            {
                for (int totalLen = partLength; totalLen <= totalBeads ; totalLen+=partLength)
                {
                    int cnt = 0, noOfReps = totalLen/partLength;
                    for (int chPos = 0; chPos < 26; chPos++) {
                        cnt += frequency[chPos]/noOfReps;
                    }
                    if (cnt>=partLength)maxLen = Math.max(maxLen, totalLen);
                }
            }
            sb.append(maxLen+"\n");
        }
        System.out.println(sb);
    }
}
