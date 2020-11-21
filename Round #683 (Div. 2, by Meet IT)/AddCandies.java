import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddCandies {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            int i= 0;
            for (i = 1; i <= n; i++) {
                arr[i-1] = i;
            }

            ArrayList<Integer>answers = new ArrayList<>();
            for( i = 1 ; i <= 1000; i++){
                boolean check = true;
                for (int j = 0; j < n - 1; j++) {
                    if (arr[j] != arr[j+1]) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    break;
                int pos = -1;
                for (int j = n - 1; j >= 0; j--) {
                    int num = arr[j] + i;
                    for (int k = 0; k < n; k++) {
                        if (k == j)continue;
                        if (num == arr[k]){
                            pos = k;
                            break;
                        }
                    }

                }
                for (int j = 0; j < n; j++) {
                    if (j == pos)continue;
                    arr[j] += i;
                }
                answers.add(pos+1);
            }
            sb.append(answers.size()+"\n");
            for (Integer answer : answers) {
                sb.append(answer+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
