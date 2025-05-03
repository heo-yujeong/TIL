package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5212 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        char[][] newMap = new char[R][C];
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                int cnt = 0;
                if (map[y][x] == 'X') {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                            cnt++;
                        } else {
                            if (map[ny][nx] == '.') {
                                cnt++;
                            }
                        }
                    }

                    if (cnt >= 3) {
                        newMap[y][x] = '.';
                    } else {
                        newMap[y][x] = 'X';
                    }
                } else {
                    newMap[y][x] = '.';
                }
            }
        }

        int left = C, right = -1;
        int top = R, bottom = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newMap[i][j] == 'X') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }
    }
}
