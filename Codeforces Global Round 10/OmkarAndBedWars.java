import java.io.*;
import java.util.*;

public class OmkarAndBedWars {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char[]s = new char[n];
            String inp = buffer.readLine();
            for (int i = 0; i < n; i++) {
                s[i] = inp.charAt(i);
            }
            int cnt = 0;
            ArrayList<Integer>arrayList = new ArrayList<>();
            int temp = 1;
            char prev = s[0];

            for (int pos = 1; pos < n; pos++) {
                if (s[pos]==prev){
                    temp++;
                }
                else {
                    arrayList.add(temp);
                    temp = 1;
                    prev = s[pos];
                }
            }
            if (arrayList.size()==0)
                cnt = (temp+2)/3;
            else if (s[0]==s[n-1])
                arrayList.set(0, arrayList.get(0)+temp);
            else
                arrayList.add(temp);
            for (int sum:arrayList)
                cnt += sum/3;
//            System.out.println(Arrays.toString(s));
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
