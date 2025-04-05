package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ20168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }

        int[][] totalCost = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            totalCost[i][0] = Integer.MAX_VALUE;
            totalCost[i][1] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        totalCost[A][0] = 0;
        totalCost[A][1] = 0;
        pq.offer(new int[]{A, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == B) {
                System.out.println(now[1]);
                return;
            }

            for (int i = 0; i < graph.get(now[0]).size(); i++) {
                int[] next = graph.get(now[0]).get(i);

                if (now[2] + next[1] <= C) {
                    if (totalCost[next[0]][0] > Math.max(now[1], next[1])) {
                        totalCost[next[0]][0] = Math.max(now[1], next[1]);

                        if (totalCost[next[0]][1] > now[2] + next[1]) {
                            totalCost[next[0]][1] = now[2] + next[1];
                        }

                        pq.offer(new int[] {next[0], totalCost[next[0]][0], now[2]+next[1]});
                    } else {
                        if (totalCost[next[0]][1] > now[2] + next[1]) {
                            totalCost[next[0]][1] = now[2] + next[1];
                            pq.offer(new int[] {next[0], Math.max(now[1], next[1]), totalCost[next[0]][1]});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
