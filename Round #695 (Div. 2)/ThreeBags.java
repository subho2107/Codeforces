import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeBags {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int n1 = Integer.parseInt(inp[0]), n2 = Integer.parseInt(inp[1]), n3 = Integer.parseInt(inp[2]);
        ArrayList<Integer>a1 = new ArrayList<>(), a2 = new ArrayList<>(), a3 = new ArrayList<>();
        long sum = 0, sum1 = 0, sum2 = 0, sum3 = 0;
        inp = buffer.readLine().split(" ");
        for (String s : inp) {
            int num = Integer.parseInt(s);
            sum1 += num;
            a1.add(num);
        }
        inp = buffer.readLine().split(" ");
        for(String s: inp) {
            int num = Integer.parseInt(s);
            sum2+= num;
            a2.add(num);
        }
        inp = buffer.readLine().split(" ");
        for(String s : inp) {
            int num = Integer.parseInt(s);
            sum3 += num;
            a3.add(num);
        }
        sum = sum1 + sum2 + sum3;
        Collections.sort(a1);
        Collections.sort(a2);
        Collections.sort(a3);
        int [] smallestNums = {a1.get(0), a2.get(0), a3.get(0)};
        Arrays.sort(smallestNums);
        long ans = sum - 2*((long)smallestNums[0]+smallestNums[1]);
        long minSum = Math.min(sum1, Math.min(sum2, sum3));
        ans = Math.max(ans, sum-2*minSum);
        System.out.println(ans);
    }
}
