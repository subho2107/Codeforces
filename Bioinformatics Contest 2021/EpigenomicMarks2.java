import java.io.*;
import java.util.HashMap;

public class EpigenomicMarks2 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/home/tirthankar/PycharmProjects/Codeforces/Bioinformatics Contest 2021/2.txt");
        BufferedReader buffer = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        FileWriter fw=new FileWriter("/home/tirthankar/PycharmProjects/Codeforces/Bioinformatics Contest 2021/output.txt");
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), l = Integer.parseInt(inp[1]);
            int [][] matrix = new int[n][l];
            for (int i = 0; i < n; i++) {
                char [] temp = buffer.readLine().toCharArray();
                for (int j = 0; j < l; j++) {
                    matrix[i][j] = temp[j];
                }
            }
            int num = 1, state = 0;
            HashMap<String, Integer>map = new HashMap<>();
            int [] ans = new int[l];
            for (int i = 0; i < l; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    temp.append(matrix[j][i]);
                }
                String key = temp.toString();
                if (!map.containsKey(key))
                    map.put(key, num++);
                ans[i] = map.get(key);
                state = Math.max(state, ans[i]);
            }
            sb.append(state).append("\n");
            for (int i : ans) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        fw.write(sb.toString());
        fw.close();
    }
}
