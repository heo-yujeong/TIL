package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {
    static int[][] paper;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        for (int n : cnt) {
            System.out.println(n);
        }
    }

    private static void divide(int y, int x, int size) {
        if (number(y, x, size) == -1) {
            cnt[0]++;
            return;
        } else if (number(y, x, size) == 0) {
            cnt[1]++;
            return;
        } else if (number(y, x, size) == 1) {
            cnt[2]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(y + i*newSize, x + j*newSize, newSize);
            }
        }
    }

    private static int number(int y, int x, int size) {
        int num = paper[y][x];

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if (paper[i][j] != num) {
                    return 2;
                }
            }
        }

        return num;
    }
}
