import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SerejaAndDima {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int sereja = 0, dima = 0;
            int start = 0, end = n-1;
            int serejaTurn = 1;
            while (start <= end){
                int score = arr[end];
                if (arr[start] > arr[end]) {
                    score = arr[start];
                    start++;
                }
                else
                    end--;
                if(serejaTurn == 1)
                    sereja += score;
                else
                    dima += score;
                serejaTurn ^= 1;
            }
            sb.append(sereja+" "+dima).append("\n");
        }
        System.out.println(sb);
    }
}
