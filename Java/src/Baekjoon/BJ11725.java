package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
    static ArrayList<Integer>[] graph;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(visit[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            for (int next : graph[now]) {
                if (visit[next] == 0) {
                    visit[next] = now;
                    deque.add(next);
                }
            }
        }
    }
}
