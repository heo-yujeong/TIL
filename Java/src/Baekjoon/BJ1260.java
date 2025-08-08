package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        visit = new boolean[N+1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(" ");

        for (int next : graph.get(v)) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for (int next : graph.get(now)) {
                if (!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
    }
}
