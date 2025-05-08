package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11559 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            field[i] = br.readLine().toCharArray();
        }

        int time = 0;

        while (true) {
            boolean[][] visit = new boolean[12][6];
            List<int[]> bombList = new ArrayList<>();

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.' && field[i][j] != '_' && !visit[i][j]) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        List<int[]> position = new ArrayList<>();
                        char start = field[i][j];

                        queue.add(new int[]{i, j});
                        position.add(new int[]{i, j});
                        visit[i][j] = true;

                        while (!queue.isEmpty()) {
                            int[] now = queue.poll();
                            int x = now[1];
                            int y = now[0];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];
                                if (nx >= 0 && ny >= 0 && nx < 6 && ny < 12 && field[ny][nx] == start && !visit[ny][nx]) {
                                    visit[ny][nx] = true;
                                    queue.add(new int[]{ny, nx});
                                    position.add(new int[]{ny, nx});
                                }
                            }
                        }

                        if (position.size() >= 4) {
                            position.sort((o1, o2) -> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);
                            for (int[] pos : position) {
                                field[pos[0]][pos[1]] = '_';
                                bombList.add(new int[]{pos[0], pos[1]});
                            }
                        }
                    }
                }
            }

            if (bombList.isEmpty()) break;

            for (int[] bomb : bombList) {
                int x = bomb[1];
                int y = bomb[0];
                for (int i = y; i > 0; i--) {
                    field[i][x] = field[i-1][x];
                }
                field[0][x] = '.';
            }
            time++;
        }

        System.out.println(time);
    }
}
