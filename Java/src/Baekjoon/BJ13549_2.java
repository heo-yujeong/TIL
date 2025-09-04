package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549_2 {
    static int N, K;
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(N);
        System.out.println(dist[K]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (now == K) return;
            if (cost > dist[now]) continue;

            int[] moves = {now * 2, now + 1, now - 1};
            for (int next : moves) {
                if (0 <= next && next <= 100000) {
                    int nextCost = cost + ((next == now * 2) ? 0 : 1);
                    if (nextCost < dist[next]) {
                        dist[next] = nextCost;
                        pq.offer(new int[]{next, nextCost});
                    }
                }
            }
        }
    }
}
