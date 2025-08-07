package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n+1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        int cnt = 0;
        for (int i = 2; i < n+1; i++) {
            if (visit[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visit[num] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
    }
}
