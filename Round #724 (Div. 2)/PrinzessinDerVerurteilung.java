import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrinzessinDerVerurteilung {
    public static String next(String s) {
        char[] arr = s.toCharArray();
        if (arr[arr.length - 1] != 'z') {
            arr[arr.length - 1] = (char) (arr[arr.length - 1] + 1);
            return String.valueOf(arr);
        } else {
            for (int i = s.length()-1; i >= 0; i--) {
                if (arr[i] == 'z')
                    arr[i] = 'a';
                else {
                    arr[i] = (char) (arr[i] + 1);
                    break;
                }
            }
            if (arr[0] == 'a' && s.charAt(0) == 'z')
                return "a" + String.valueOf(arr);
            else
                return String.valueOf(arr);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String s = buffer.readLine();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    list.add(s.substring(i, j + 1));
                }
            }
            list.sort((o1, o2) -> {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            });
            if (!list.get(0).equals("a")) {
                sb.append("a\n");
                continue;
            }
            String ans = "";
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i+1)))
                    continue;
                String temp = next(list.get(i));
                if (!temp.equals(list.get(i + 1))) {
                    ans = temp;
                    break;
                }
            }
            if (ans.length() == 0)
                ans = next(s);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
