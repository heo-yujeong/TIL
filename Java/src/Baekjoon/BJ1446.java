package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end > D)
                continue;
            if (end-start > dist)
                graph.get(start).add(new int[] {end, dist});
        }

        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDist = cur[1];

            if (nowDist > dist[now]) {
                continue;
            }

            if (now+1 <= D && dist[now+1] > nowDist+1) {
                dist[now+1] = nowDist+1;
                pq.offer(new int[] {now+1, dist[now+1]});
            }

            for (int[] g : graph.get(now)) {
                int next = g[0];
                int nextDist = g[1];

                if (dist[next] > nowDist + nextDist) {
                    dist[next] = nowDist + nextDist;
                    pq.offer(new int[] {next, dist[next]});
                }
            }
        }
        System.out.println(dist[D]);
        br.close();
    }
}
