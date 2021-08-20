import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContestStart {
    static int[][] positions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static HashMap<Integer, HashSet<Integer>> visited;
    public static boolean dfs(char[][] matrix, int n, int m, int i, int j, char parent) {
        if (i >= n || j >= m || i < 0 || j < 0 || (visited.containsKey(i) && visited.get(i).contains(j)) )
            return true;
        if (!visited.containsKey(i))
            visited.put(i, new HashSet<>());
        visited.get(i).add(j);
        char supposedToBe = parent == 'R'?'W':'R';
        for (int[] position : positions) {
            int x = position[0] + i, y = position[1] + j;
            if (x >= 0 && y >= 0 && x < n && y < m) {
                if (matrix[x][y] == '.') {
                    matrix[x][y] = supposedToBe;
                }
                else if (matrix[x][y] != supposedToBe) {
                    return false;
                }
                if (!dfs(matrix, n, m, x, y, supposedToBe))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            visited = new HashMap<>();
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            char[][] matrix = new char[n][m];
            boolean dot = false;int x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                char[] arr = buffer.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = arr[j];
                    if (matrix[i][j] != '.' && x == -1) {
                        x = i;
                        y = j;
                    }else if (matrix[i][j] == '.')
                        dot = true;
                }
            }
            if (!dot){
                sb.append("YES\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        sb.append(matrix[i][j]);
                    }
                    sb.append("\n");
                }continue;
            }
            if (x != -1) {
                if (dfs(matrix, n, m, x, y, matrix[x][y])) {
                    sb.append("YES\n");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            sb.append(matrix[i][j]);
                        }
                        sb.append("\n");
                    }
                } else
                    sb.append("NO\n");
            } else {
                boolean check = dfs(matrix, n, m, 0, 0, 'R');
                if (!check)
                {
                    for (int i = 0; i < n; i++) {
                        Arrays.fill(matrix[i], '.');
                    }
                    check = dfs(matrix, n, m, 0, 0, 'W');
                }
                if (check) {
                    sb.append("YES\n");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            sb.append(matrix[i][j]);
                        }
                        sb.append("\n");
                    }
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
