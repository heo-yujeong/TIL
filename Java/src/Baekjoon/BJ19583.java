package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken().replace(":", ""));
        int E = Integer.parseInt(st.nextToken().replace(":", ""));
        int Q = Integer.parseInt(st.nextToken().replace(":", ""));

        HashSet<String> set = new HashSet<>();
        String input;
        int result = 0;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();

            if (time <= S) {
                set.add(name);
            }

            if (E <= time && time <= Q && set.contains(name)) {
                result++;
                set.remove(name);
            }
        }

        System.out.println(result);
        br.close();
    }
}
