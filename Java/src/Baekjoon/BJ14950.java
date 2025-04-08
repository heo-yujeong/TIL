package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] load = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 1; i <= N; i++) {
            load[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            load[A].add(new int[]{B, C});
            load[B].add(new int[]{A, C});
        }

        long total = 0L;
        int time = -1;
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visited[now[0]]) {
                continue;
            }

            visited[now[0]] = true;
            if (time == -1) {
                time++;
            } else {
                total += now[1] + time++ * t;
            }

            for (int[] next : load[now[0]]) {
                pq.add(new int[]{next[0], next[1]});
            }
        }
        System.out.println(total);
    }
}
