package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ12908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());

        int[][] board = new int[8][2];
        long[][] dist = new long[8][8];

        board[0][0] = xs;
        board[0][1] = ys;
        board[7][0] = xe;
        board[7][1] = ye;

        for (int i = 0; i < 8; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][7] = dist[7][0] = Math.abs(xs - xe) + Math.abs(ys - ye);

        for (int i = 1; i < 7; i+=2) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i+1][0] = Integer.parseInt(st.nextToken());
            board[i+1][1] = Integer.parseInt(st.nextToken());

            dist[i][i+1] = dist[i+1][i] = Math.min(Math.abs(board[i][0] - board[i+1][0]) + Math.abs(board[i][1] - board[i+1][1]), 10);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                dist[i][j] = Math.min(dist[i][j], Math.abs(board[i][0] - board[j][0]) + Math.abs(board[i][1] - board[j][1]));
            }
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        System.out.println(dist[0][7]);
    }
}
