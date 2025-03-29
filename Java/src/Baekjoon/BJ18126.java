package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<int[]>[] room = new ArrayList[N+1];
        boolean[] visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            room[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            room[A].add(new int[] {B, C});
            room[B].add(new int[] {A, C});
        }

        long result = 0;
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] {1, 0});
        visit[1] = true;

        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            int nowRoom = (int) now[0];
            long totalDist = now[1];
            result = Math.max(result, totalDist);

            for (int[] next : room[nowRoom]) {
                int nextRoom = next[0];
                int nextDist = next[1];
                if (!visit[nextRoom]) {
                    visit[nextRoom] = true;
                    queue.add(new long[] {nextRoom, totalDist+nextDist});
                }
            }
        }

        System.out.println(result);
    }
}
