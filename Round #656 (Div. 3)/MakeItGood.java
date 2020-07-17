import java.io.*;
import java.util.*;

public class MakeItGood {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int[]arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            int l =0;
            while(true)
            {
                int r = n-1;
                ArrayList<Integer>temp = new ArrayList<>();
                int l2 = l, r2 = r;
                boolean check = true;
                while (l2!=r2)
                {
                    if (arr[l2] < arr[r2])
                    {
                        if (temp.size() == 0 || arr[l2] >= temp.get(temp.size()-1)) {
                            temp.add(arr[l2]);
                            l2++;
                        }
                        else
                        {
                            check = false;
                            break;
                        }
                    }
                    else
                    {
                        if (temp.size()==0 || arr[r2] >= temp.get(temp.size()-1))
                        {
                            temp.add(arr[r2]);
                            r2--;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                if (l2 == r2)
                    break;
                l = l2;
                if (check)l++;
            }
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }
}
