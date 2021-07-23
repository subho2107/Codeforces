import java.io.*;
import java.util.*;

public class Penalty {
    static Set<String> set;
    public static void  createAllScenarios(char [] arr, int i){
        if (i == arr.length) {
            set.add(String.valueOf(arr));
            return;
        }
        if (arr[i] != '?')
             createAllScenarios(arr, i+1);
        else {
            arr[i] = '0';
            createAllScenarios(arr, i+1);
            arr[i] = '1';
            createAllScenarios(arr, i+1);
            arr[i] = '?';
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] s = buffer.readLine().toCharArray();
            set = new HashSet<>();
            createAllScenarios(s, 0);
            int ans = 10;
            for (String curr : set) {
                int a = 0, b = 0, currAns = 10;
                for (int i = 0; i < curr.length(); i++) {
                    char ch = curr.charAt(i);
                    if (ch == '1')
                    {
                        if (i % 2 == 0)
                            a++;
                        else
                            b++;
                    }
                    int left = (curr.length()-1-i);
                    int forA = left/2, forB = left/2;
                    if (left % 2 == 1)
                        forB++;
                    if (a+forA < b || b+forB < a)
                    {
                        currAns = i+1;
                        break;
                    }
                }
                ans = Math.min(ans, currAns);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
