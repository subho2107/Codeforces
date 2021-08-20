import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TheChildAndSet {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buffer.readLine().split(" ");
        int sum = Integer.parseInt(inp[0]), limit = Integer.parseInt(inp[1]);
        int [][] lowBitVals = new int[limit][2];
        for (int i = 1; i <= limit; i++) {
            lowBitVals[i-1][0] = i&(-i);
            lowBitVals[i-1][1] = i;
        }
        Arrays.sort(lowBitVals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<Integer>res = new ArrayList<>();
        for (int i = limit-1; i >= 0 ; i--) {
            if (sum >= lowBitVals[i][0]) {
                sum -= lowBitVals[i][0];
                res.add(lowBitVals[i][1]);
            }
        }
        if (sum != 0)
            System.out.println(-1);
        else {
            System.out.println(res.size());
            for (Integer re : res) {
                System.out.print(re+" ");
            }
        }
    }
}
