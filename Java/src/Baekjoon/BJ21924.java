package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ21924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] load = new ArrayList[N+1];
        boolean[] visit = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        long result = 0L;

        for (int i = 0; i <= N; i++) {
            load[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            load[a].add(new int[] {b, c});
            load[b].add(new int[] {a, c});
            result += c;
        }

        long min = 0L;
        pq.add(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visit[now[0]]) {
                continue;
            }

            visit[now[0]] = true;
            min += now[1];

            for (int[] next : load[now[0]]) {
                if (!visit[next[0]]) {
                    pq.add(next);
                }
            }
        }

        int notVisit = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                notVisit++;
            }
        }

        if (notVisit > 0) {
            System.out.println(-1);
        } else {
            System.out.println(result - min);
        }
    }
}
