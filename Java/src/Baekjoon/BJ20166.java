package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ20166 {
    static int N, M;
    static int maxLength = 0;
    static char[][] tile;
    static Map<String, Integer> map = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tile = new char[N+1][M+1];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                tile[i][j] = line.charAt(j);
            }
        }

        String[] chrSet = new String[K];
        for (int i = 0; i < K; i++) {
            String line = br.readLine();
            map.put(line, 0);
            chrSet[i] = line;
            maxLength = Math.max(maxLength, line.length());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, String.valueOf(tile[i][j]));
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.println(map.get(chrSet[i]));
        }
    }

    private static void dfs(int y, int x, String s) {
        if (map.get(s) != null) {
            map.put(s, map.get(s) + 1);
        }

        if (s.length() == maxLength) {
            return;
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0) nx = M-1;
            if (nx >= M) nx = 0;
            if (ny < 0) ny = N-1;
            if (ny >= N) ny = 0;

            dfs(ny, nx, s+String.valueOf(tile[ny][nx]));
        }
    }
}
