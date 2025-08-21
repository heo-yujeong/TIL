package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992_2 {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = input.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);
        System.out.println(sb);
    }

    private static void QuadTree(int y, int x, int size) {
        if (isPossible(y, x, size)) {
            sb.append(video[y][x]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        QuadTree(y, x, newSize);
        QuadTree(y, x+newSize, newSize);
        QuadTree(y+newSize, x, newSize);
        QuadTree(y+newSize, x+newSize, newSize);

        sb.append(')');
    }

    private static boolean isPossible(int y, int x, int size) {
        int color = video[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != video[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
