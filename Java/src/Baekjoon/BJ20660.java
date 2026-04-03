package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ20660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Set<Integer> dislike = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dislike.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            boolean ok = true;

            for (int j = 0; j < k; j++) {
                int b = Integer.parseInt(st.nextToken());
                if (dislike.contains(b)) {
                    ok = false;
                }
            }

            if (ok) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
