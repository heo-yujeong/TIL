package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ24479 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;
    static int[] result;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(graph.get(i));
        }

        result = new int[N+1];

        dfs(R);

        for (int i = 1; i < N+1; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int r) {
        visit[r] = true;
        result[r] = order++;

        for (int x : graph.get(r)) {
            if (!visit[x]) {
                dfs(x);
            }
        }
    }
}
