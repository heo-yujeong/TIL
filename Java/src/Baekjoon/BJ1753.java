package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1753 {
    static ArrayList<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void dijkstra(int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, k});
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int now = cur[1];

            if (dist[now] < cost) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int weight = next[1];

                if (dist[nextNode] > dist[now] + weight) {
                    dist[nextNode] = dist[now] + weight;
                    pq.offer(new int[] {dist[nextNode], nextNode});
                }
            }
        }
    }
}
