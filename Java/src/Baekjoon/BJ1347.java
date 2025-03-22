package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] mv = br.readLine().toCharArray();

        char[][] map = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int startX, startY, minX, minY, maxX, maxY;
        startX = startY = minX = minY = maxX = maxY = 50;
        map[startX][startY] = '.';

        int dir = 2;

        for (int i = 0; i < mv.length; i++) {
            if (mv[i] == 'F') {
                startX += dx[dir];
                startY += dy[dir];
                map[startY][startX] = '.';

                maxX = Math.max(maxX, startX);
                maxY = Math.max(maxY, startY);

                minX = Math.min(minX, startX);
                minY = Math.min(minY, startY);
            } else if (mv[i] == 'L') {
                dir = (dir == 0) ? 3 : dir-1;
            } else if (mv[i] == 'R') {
                dir = (dir == 3) ? 0 : dir+1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
