package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16928 {
    static int[] board = new int[101];
    static int[] visit = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 100) {
                System.out.println(visit[now]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next <= 100) {
                    int dest = (board[next] != 0) ? board[next] : next;
                    if (visit[dest] == 0 && dest != 1) {
                        queue.offer(dest);
                        visit[dest] = visit[now] + 1;
                    }
                }
            }
        }
    }
}
