package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17829 {
    static int N;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recur(0, 0, N));
        br.close();
    }

    private static int recur(int i, int j, int size) {
        if (size == 2) {
            int[] tmp = new int[4];
            int idx = 0;

            for (int r = i; r < i+2; r++) {
                for (int c = j; c < j+2; c++) {
                    tmp[idx++] = matrix[r][c];
                }
            }

            Arrays.sort(tmp);
            return tmp[2];
        } else {
            int[] tmp = new int[4];
            size = size / 2;

            tmp[0] = recur(i, j, size);
            tmp[1] = recur(i, j+size, size);
            tmp[2] = recur(i+size, j, size);
            tmp[3] = recur(i+size, j+size, size);

            Arrays.sort(tmp);
            return tmp[2];
        }
    }
}
