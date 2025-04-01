package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ5972 {
    static ArrayList<int[]>[] load;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        load = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            load[i] = new ArrayList<>();
        }
        visit = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            load[A].add(new int[] {B, C});
            load[B].add(new int[] {A, C});
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {1, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];

            if (visit[nowNode]) {
                continue;
            }
            visit[nowNode] = true;

            for (int[] next : load[nowNode]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > dist[nowNode] + nextCost) {
                    dist[nextNode] = dist[nowNode] + nextCost;
                    pq.offer(new int[] {nextNode, dist[nextNode]});
                }
            }
        }
    }
}
