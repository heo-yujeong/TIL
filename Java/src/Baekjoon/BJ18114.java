package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] W = new int[N];

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            W[i] = now;
            set.add(now);
            if (now == C) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int remain = C - W[i];
            if (W[i] == remain) continue;
            if (set.contains(remain)) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int remain = C - (W[i] + W[j]);
                if (remain == W[i] || remain == W[j]) continue;
                if (set.contains(remain)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
