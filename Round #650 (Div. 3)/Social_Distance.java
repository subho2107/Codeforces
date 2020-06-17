import java.io.*;
import java.util.*;

public class Social_Distance {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[]s = buffer.readLine().split(" ");
            int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
            String temp = buffer.readLine();
            char[]status = temp.toCharArray();
            int first1 = temp.indexOf('1');
            int last1 = temp.lastIndexOf('1');
            if(first1==-1)
            {
                int ans =0;
                for (int pos = 0; pos < status.length; pos+=k+1) {
                    ans++;
                }
                sb.append(ans+"\n");
                continue;
            }
            int[]left1 = new int [n];
            int[]right1 = new int[n];
            int leftMost = first1;
            for (int pos = first1+1; pos < status.length; pos++) {
                if(status[pos]=='1')
                {
                    leftMost = pos;
                }
                left1[pos] = leftMost;
            }
            int rightMost = last1;
            for (int pos = last1-1; pos >= 0 ; pos--)
            {
                if(status[pos]=='1')
                {
                    rightMost = pos;
                }
                right1[pos] = rightMost;
            }
            int cnt = 0;
            leftMost = temp.indexOf('1'); rightMost = temp.lastIndexOf('1');
            for(int pos = first1+1; pos < last1; pos++)
            {
                if(status[pos]=='1')
                {
                    leftMost = pos;
                }
                left1[pos] = leftMost;
                if(status[pos]=='0' && pos-left1[pos]>k && right1[pos]-pos>k)
                {
                    cnt++;
                    status[pos] = '1';
                }
                if(status[pos]=='1')
                {
                    leftMost = pos;
                }
            }
            for (int pos = first1-k-1; pos >=0 ; pos-=k+1) {
                cnt++;
            }
            for (int pos = last1+k+1; pos < status.length; pos+=k+1) {
                cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

}
