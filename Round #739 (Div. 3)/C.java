import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(buffer.readLine());
            int diagonal = 1,elements = 1, num = 1, d = 1, r = -1, c = -1;
            while (true){
                int half = elements/2;
                if (k >= num-half && k <= num+half){
                    if (k == num){
                        r = diagonal;c = diagonal;
                    }
                    else if (k < num){
                        r = diagonal-(num-k);c = diagonal;
                    }
                    else {
                        r = diagonal;c = diagonal-(k-num);
                    }
                    break;
                }
                d=2*diagonal;
                diagonal++;
                num += d;
                elements+=2;
            }
            sb.append(r+" "+c+"\n");
        }
        System.out.println(sb);
    }
}
