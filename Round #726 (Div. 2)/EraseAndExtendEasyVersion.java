import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EraseAndExtendEasyVersion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
        String s = buffer.readLine();
        StringBuilder temp = new StringBuilder();
        String repeatingPart = s;
        for (int i = 0; i < n-1; i++) {
            int minLength = Math.min(i+1, n-i-1);
            int val = s.substring(0, minLength).compareTo(s.substring(i+1, i+1+minLength));
            if (val <= 0){
                repeatingPart = s.substring(0, i+1);
                break;
            }
        }
        while (temp.length() < k)
            temp.append(repeatingPart);
        System.out.println(temp.substring(0, k));
    }
}
