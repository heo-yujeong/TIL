package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1504 {
    static int N;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long path1 = (long) dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long path2 = (long) dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (path1 >= Integer.MAX_VALUE && path2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(path1, path2));
        }
    }

    private static long dijkstra(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nowDist = cur[0];
            int now = cur[1];

            if (dist[now] < nowDist) continue;

            for (int[] next : graph.get(now)) {
                int nextNode = next[0];
                int d = next[1];

                if (dist[nextNode] > dist[now] + d) {
                    dist[nextNode] = dist[now] + d;
                    pq.add(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        return dist[end];
    }
}
