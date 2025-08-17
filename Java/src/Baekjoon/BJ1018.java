package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {
    static char[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    private static void find(int y, int x) {
        int cnt = 0;
        char first = arr[y][x];

        for (int i = y; i < y+8; i++) {
            for (int j = x; j < x+8; j++) {
                if (arr[i][j] != first) {
                    cnt++;
                }

                first = (first == 'B') ? 'W' : 'B';
            }
            first = (first == 'B') ? 'W' : 'B';
        }

        cnt = Math.min(cnt, 64-cnt);

        min = Math.min(min, cnt);
    }
}
