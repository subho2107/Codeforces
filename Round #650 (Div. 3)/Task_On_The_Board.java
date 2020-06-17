import java.io.*;
import java.util.*;
public class Task_On_The_Board {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0)
        {
            String originalString = buffer.readLine();
            int len = Integer.parseInt(buffer.readLine());
            String[]inp = buffer.readLine().split(" ");
            int [] b = new int[len];
            int [] frequency = new int[26];
            ArrayList<Integer>zeroes = new ArrayList<Integer>();
            for (int pos = 0; pos < len; pos++) {
                b[pos] = Integer.parseInt(inp[pos]);
                if(b[pos]==0)
                {
                    zeroes.add(pos);
//                    b[pos] = -1;
                }
            }
            for (char ch :
                    originalString.toCharArray()) {
                frequency[ch - 'a'] += 1;
            }
            
            char [] newFormedStr = new char[len];
            for (int ascii = 25; ascii >= 0 ; ascii--)
            {
                if(frequency[ascii]==0||zeroes.size()>frequency[ascii])continue;
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for (Integer zeroPos :zeroes)
                {
                    newFormedStr[zeroPos] = (char)(ascii+97);

                    b[zeroPos] = -1;
                    for (int pos = 0; pos < len; pos++) {
                        if(b[pos]!=-1)
                        {
                            b[pos]-=Math.abs(pos-zeroPos);
                        }
                        if (b[pos]==0)
                        {
                            temp.add(pos);
                        }
                    }
                }
                zeroes = new ArrayList<Integer>(temp);
            }
//            String ans = "";
//            System.out.println(String.valueOf(originalString.toCharArray()));
            sb.append(String.valueOf(newFormedStr)+"\n");
        }
        System.out.println(sb);
    }
}
