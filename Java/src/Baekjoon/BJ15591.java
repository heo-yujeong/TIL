package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new int[] {q, r});
            graph[q].add(new int[] {p, r});
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visit = new boolean[N+1];
            visit[v] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            int result = 0;
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int[] next : graph[now]) {
                    if (!visit[next[0]] && next[1] >= k) {
                        visit[next[0]] = true;
                        queue.add(next[0]);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
