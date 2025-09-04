package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13549 {
    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(visit[K] - 1);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) return;

            int[] moves = {now * 2, now - 1, now + 1};
            for (int next : moves) {
                if (0 <= next && next <= 100000 && (visit[next] == 0 || visit[next] > visit[now])) {
                    if (next == now * 2) {
                        visit[next] = visit[now];
                    } else {
                        visit[next] = visit[now] + 1;
                    }
                    queue.add(next);
                }
            }
        }
    }
}
