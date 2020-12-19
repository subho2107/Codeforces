import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Taxi {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] arr = new int[n];
        int [] cnt = {0,0,0,0};
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
            cnt[arr[i]-1]++;
        }
        int ans = cnt[3]+Math.min(cnt[0], cnt[2])+(cnt[1]/2);
        int min = Math.min(cnt[0], cnt[2]);
        cnt[3] = 0;
        cnt[0] -= min;
        cnt[2] -= min;
        cnt[1] %= 2;
        if (cnt[1] == 1){
            if (cnt[2] != 0){
                ans += cnt[2]+1;
            }
            else
            {
                cnt[0] += 2*cnt[1];
                ans += cnt[0]/4;
                if (cnt[0] % 4 != 0)
                    ans++;
            }
        }
        else {
            if (cnt[2] != 0)
                ans += cnt[2];
            else
            {
                ans += cnt[0] / 4;
                if (cnt[0] % 4 != 0)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
