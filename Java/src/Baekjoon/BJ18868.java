package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] space = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < M-1; i++) {
            for (int j = i+1; j < M; j++) {
                boolean chk = true;

                for (int a = 0; a < N-1 && chk; a++) {
                    for (int b = a+1; b < N; b++) {
                        if (space[i][a] > space[i][b]) {
                            if (space[j][a] <= space[j][b]) {
                                chk = false;
                                break;
                            }
                        } else if (space[i][a] == space[i][b]) {
                            if (space[j][a] != space[j][b]) {
                                chk = false;
                                break;
                            }
                        } else {
                            if (space[j][a] >= space[j][b]) {
                                chk = false;
                                break;
                            }
                        }
                    }
                }

                if (chk) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
