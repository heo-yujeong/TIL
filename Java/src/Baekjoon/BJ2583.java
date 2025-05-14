package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2583 {
    static int N, M, K;
    static int[][] paper;
    static int cnt = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int luX = Integer.parseInt(st.nextToken());
            int luY = Integer.parseInt(st.nextToken());
            int ruX = Integer.parseInt(st.nextToken());
            int ruY = Integer.parseInt(st.nextToken());

            for (int j = luX; j < ruX; j++) {
                for (int k = luY; k < ruY; k++) {
                    paper[k][j] = 1;
                }
            }
        }

        List<Integer> areaCnt = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    areaCnt.add(cnt);
                }
            }
        }

        System.out.println(areaCnt.size());
        Collections.sort(areaCnt);
        for (int cnt : areaCnt) {
            System.out.print(cnt + " ");
        }
    }

    private static void dfs(int y, int x) {
        paper[y][x] = 1;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && paper[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }
}
