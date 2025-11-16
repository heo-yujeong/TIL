package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21736 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] campus = new char[N][M];
        boolean[][] visit = new boolean[N][M];

        int[] doyeon = new int[2];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char chr = line[j];
                if (chr == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = j;
                }

                campus[i][j] = chr;
            }
        }

        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{doyeon[0], doyeon[1]});
        visit[doyeon[0]][doyeon[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int next_x = now[1] + dx[d];
                int next_y = now[0] + dy[d];

                if (next_x >= 0 && next_x < M && next_y >= 0 && next_y < N && campus[next_y][next_x] != 'X' && !visit[next_y][next_x]) {
                    queue.add(new int[]{next_y, next_x});
                    visit[next_y][next_x] = true;

                    if (campus[next_y][next_x] == 'P') {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}
