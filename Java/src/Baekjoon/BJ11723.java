package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            } else if (order.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (order.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            } else if (order.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            } else if (order.equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb);
    }
}
