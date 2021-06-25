import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BadBoy {
    public static long getDist(int [] ints, int [] ints1){
        return Math.abs(ints1[0] - ints[0])+Math.abs(ints1[1] - ints[1]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]), x = Integer.parseInt(inp[2]), y = Integer.parseInt(inp[3]);
            int [][] arr = {{1, 1}, {1, m}, {n, 1}, {n, m}};
            int [] ans1 = {x, y}, ans2 = {x, y};
            long maxDist = 0;
            int [] temp = {x, y};
            for (int[] ints : arr) {
                for (int[] ints1 : arr) {
                    long dist = Math.min(2*getDist(temp, ints)+2*getDist(temp, ints1), getDist(temp, ints1)+getDist(temp, ints)+getDist(ints, ints1));
                    if (dist > maxDist){
                        maxDist = dist;
                        ans1[0] = ints[0];ans1[1]  =ints[1]; ans2[0] = ints1[0]; ans2[1] = ints1[1];
                    }
                }
            }
            sb.append(ans1[0]+" "+ans1[1]+" "+ans2[0]+" "+ans2[1]).append("\n");
        }
        System.out.println(sb);
    }
}
