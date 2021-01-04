import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AntonAndDanik {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String s = buffer.readLine();
        int cntD = 0, cntA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A')cntA++;
            else cntD++;
        }
        if (cntA > cntD)
        System.out.println("Anton");
        else if (cntD > cntA)
            System.out.println("Danik");
        else
            System.out.println("Friendship");
    }
}
