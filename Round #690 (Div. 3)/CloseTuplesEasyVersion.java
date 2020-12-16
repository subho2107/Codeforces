import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CloseTuplesEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int []freq = new int[n+1];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
                freq[arr[i]]++;
            }
            for (int minNum = 0; minNum < n + 1; minNum++) {
                if (freq[minNum] == 0)
                    continue;
                for (int j = freq[minNum]-2; j > 0; j--) //when triplet has all equal elements
                    ans += (long) j * (j + 1) /2;
                for (int maxNum = minNum+1; maxNum <= minNum+2 && maxNum <= n; maxNum++) {
                    if(freq[maxNum] == 0)
                        continue;
                    ans += ((long) (freq[minNum] - 1) * freq[minNum] / 2) *(freq[maxNum]);//triplet has two unique elements
                    ans += (long) (freq[maxNum] - 1) * freq[maxNum] / 2 * freq[minNum];//triplet has two unique elements
                    int tempSum = 0;
                    for (int midNum = minNum+1; midNum < maxNum; midNum++)
                        tempSum += freq[midNum];
                    ans += (long) tempSum *freq[maxNum]*freq[minNum];//triplet has three unique elements
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
