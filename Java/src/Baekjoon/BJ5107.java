package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ5107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            int cnt = 0;
            ArrayList<String> names = new ArrayList<>();
            HashMap<String, String> manito = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                manito.put(from, to);
                names.add(from);
            }

            for (String from : names) {
                String to = manito.get(from);

                while (true) {
                    to = manito.get(to);
                    if (to == null)
                        break;
                    else if (to.equals(from)) {
                        manito.remove(to);
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println(testCase + " " + cnt);
            testCase++;
        }
        br.close();
    }
}
