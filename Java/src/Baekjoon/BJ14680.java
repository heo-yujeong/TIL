package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14680 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[][]> matrix = new ArrayList<>();
        List<int[]> matSize = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int[][] mat = new int[X][Y];
            for (int j = 0; j < X; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < Y; k++) {
                    mat[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (i > 0) {
                int[] prevSize = matSize.get(i-1);
                if (prevSize[1] != X) {
                    System.out.println(-1);
                    return;
                }
            }

            matrix.add(mat);
            matSize.add(new int[]{X, Y});
        }

        int[][] curMat = matrix.get(0);
        int curX = matSize.get(0)[0];
        int curY = matSize.get(0)[1];

        for (int i = 1; i < N; i++) {
            int[][] nextMat = matrix.get(i);
            int nextY = matSize.get(i)[1];

            int[][] prodMat = new int[curX][nextY];

            for (int j = 0; j < curX; j++) {
                for (int k = 0; k < nextY; k++) {
                    long cellSum = 0;
                    for (int l = 0; l < curY; l++) {
                        cellSum += 1L * curMat[j][l] * nextMat[l][k];
                        if (cellSum >= (long)MOD * MOD) {
                            cellSum %= MOD;
                        }
                    }
                    prodMat[j][k] = (int)(cellSum % MOD);
                }
            }

            curMat = prodMat;
            curY = nextY;
        }

        long sum = 0;
        for (int[] row : curMat) {
            for (int val : row) {
                sum = (sum + val) % MOD;
            }
        }

        System.out.println(sum);
    }
}
