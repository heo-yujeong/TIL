package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ30034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Character> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            set.add(st.nextToken().charAt(0));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            set.add(st.nextToken().charAt(0));
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            char c = st.nextToken().charAt(0);
            if (set.contains(c)) {
                set.remove(c);
            }
        }

        br.readLine();

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            if (set.contains(c) || c == ' ') {
                if (flag) {
                    sb.append("\n");
                    flag = false;
                }
                continue;
            }
            sb.append(c);
            flag = true;
        }

        System.out.println(sb);
    }
}
