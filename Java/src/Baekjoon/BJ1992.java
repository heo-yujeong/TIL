package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992 {
    static char[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = s.charAt(j);
            }
        }

        divide(0, 0, N);
        System.out.println(sb);
    }

    private static void divide(int y, int x, int size) {
        if (check(y, x, size)) {
            sb.append(video[y][x]);
            return;
        }
        sb.append("(");

        int newSize = size / 2;
        divide(y, x, newSize);
        divide(y, x+newSize, newSize);
        divide(y+newSize, x, newSize);
        divide(y+newSize, x+newSize, newSize);
        sb.append(")");
    }

    private static boolean check(int y, int x, int size) {
        char tmp = video[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (tmp != video[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
