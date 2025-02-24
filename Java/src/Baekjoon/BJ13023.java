package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
    static ArrayList<Integer>[] connect;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        connect = new ArrayList[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            connect[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a].add(b);
            connect[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (result == 0) {
                backtrack(i, 1);
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void backtrack(int now, int cnt) {
        if (cnt == 5) {
            result = 1;
            return;
        }

        visit[now] = true;
        for (int i : connect[now]) {
            if (!visit[i]) {
                backtrack(i, cnt + 1);
            }
        }
        visit[now] = false;
    }
}
