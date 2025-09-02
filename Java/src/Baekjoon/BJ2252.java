package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> student = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            student.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            student.get(A).add(B);
            indegree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            order.add(now);

            for (int next : student.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : order) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
