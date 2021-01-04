import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class EvenOddGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            int [] arr = new int[n];
            String [] inp = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            ArrayList<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
            long alice = 0, bob = 0;
            for (int num : arr) {
                if (num % 2 == 0)
                    even.add(num);
                else
                    odd.add(num);
            }
            Collections.sort(odd);Collections.sort(even);
            int turn = 0;
            while (even.size() + odd.size() != 0){
                if (turn == 0){
                    if (even.size() != 0 && (odd.size() == 0 || even.get(even.size()-1) >= odd.get(odd.size()-1))){
                        alice += even.remove(even.size()-1);
                    }
                    else
                        odd.remove(odd.size()-1);
                }
                else {
                    if (odd.size() != 0 && (even.size() == 0 || odd.get(odd.size()-1) >= even.get(even.size()-1)))
                        bob += odd.remove(odd.size()-1);
                    else
                        even.remove(even.size()-1);
                }
                turn ^= 1;
            }

            if (alice > bob)
                sb.append("Alice\n");
            else if (bob > alice)
                sb.append("Bob\n");
            else
                sb.append("Tie\n");
        }
        System.out.println(sb);
    }
}
