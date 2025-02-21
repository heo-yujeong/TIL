package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2713 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ", 3);
            int R = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);
            String msg = input[2];

            int total = R * C;
            char[][] matrix = new char[R][C];

            StringBuilder binary = new StringBuilder();
            for (char chr : msg.toCharArray()) {
                int value = (chr == ' ') ? 0 : (chr - 'A' + 1);
                binary.append(String.format("%5s", Integer.toBinaryString(value)).replace(' ', '0'));
            }

            while (binary.length() < total) {
                binary.append("0");
            }

            boolean[][] visit = new boolean[R][C];
            int r = 0;
            int c = 0;
            int dir = 0;
            for (int i = 0; i < total; i++) {
                matrix[r][c] = binary.charAt(i);
                visit[r][c] = true;

                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc]) {
                    dir = (dir + 1) % 4;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }

                r = nr;
                c = nc;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(matrix[i][j]);
                }
            }
            System.out.println(sb);
        }
        br.close();
    }
}
