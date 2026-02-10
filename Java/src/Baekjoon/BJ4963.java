package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            boolean[][] visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        Queue<int[]> q = new LinkedList<>();
                        visit[i][j] = true;
                        q.offer(new int[]{i, j});

                        while (!q.isEmpty()) {
                            int[] now = q.poll();
                            int nowX = now[1];
                            int nowY = now[0];

                            for (int d = 0; d < 8; d++) {
                                int nx = nowX + dx[d];
                                int ny = nowY + dy[d];
                                if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == 1 && !visit[ny][nx]) {
                                    visit[ny][nx] = true;
                                    q.offer(new int[]{ny, nx});
                                }
                            }
                        }

                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
