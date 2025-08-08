package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2667 {
    static int N;
    static int[][] map;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int number = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        visit = new int[N][N];

        ArrayList<Integer> numberOfHouses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visit[i][j] == 0) {
                    numberOfHouses.add(dfs(i, j));
                    number++;
                }
            }
        }

        Collections.sort(numberOfHouses);
        System.out.println(number == 1? 0: number - 1);
        for (int num : numberOfHouses) {
            System.out.println(num);
        }
    }

    private static int dfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = number;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = now[1] + dx[d];
                int ny = now[0] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] == 1 && visit[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visit[ny][nx] = number;
                }
            }
        }

        return cnt;
    }
}
