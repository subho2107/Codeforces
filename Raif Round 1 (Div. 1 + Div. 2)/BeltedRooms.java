import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeltedRooms {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char [] arr = buffer.readLine().toCharArray();
            boolean checkCycle = true;
            int clock = 0, anticlock = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == '>')
                    clock++;
                else if(arr[i] == '<')
                    anticlock++;
            }
            if (clock == 0 || anticlock == 0) {
                sb.append(n).append("\n");
                continue;
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int prev = i == 0? n-1:i-1;
                if (arr[prev] == '-' || arr[i] == '-')
                    cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
