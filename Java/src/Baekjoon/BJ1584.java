package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1584 {
    static int[][] board = new int[501][501];
    static boolean[][] visit = new boolean[501][501];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(X1, X2); j <= Math.max(X1, X2); j++) {
                for (int k = Math.min(Y1, Y2); k <= Math.max(Y1, Y2); k++) {
                    board[j][k] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(X1, X2); j <= Math.max(X1, X2); j++) {
                for (int k = Math.min(Y1, Y2); k <= Math.max(Y1, Y2); k++) {
                    board[j][k] = 2;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{0, 0, 0});
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCost = now[2];

            if (nowX == 500 && nowY == 500) {
                return nowCost;
            }

            for (int d = 0; d < 4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if (0 <= nextX && nextX < 501 && 0 <= nextY && nextY < 501 && board[nextY][nextX] != 2 && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    pq.offer(new int[]{nextX, nextY, nowCost+board[nextY][nextX]});
                }
            }
        }
        return -1;
    }
}
