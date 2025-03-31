package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3187 {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int totalSheep = 0;
    static int totalWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((map[i][j] == 'v' || map[i][j] == 'k') && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        int sheep = 0;
        int wolf = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            if (map[nowY][nowX] == 'k') {
                sheep++;
            } else if (map[nowY][nowX] == 'v') {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < C && nextY >= 0 && nextY < R && map[nextY][nextX] != '#' && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}
