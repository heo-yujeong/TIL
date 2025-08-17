package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = 64;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                int cnt = 0;
                char first = arr[i][j];

                for (int y = i; y < i+8; y++) {
                    for (int x = j; x < j+8; x++) {
                        if (arr[y][x] != first) {
                            cnt++;
                        }
                        first = (first == 'B') ? 'W' : 'B';
                    }
                    first = (first == 'B') ? 'W' : 'B';
                }

                cnt = Math.min(cnt, 64 - cnt);
                min = Math.min(min, cnt);
            }
        }

        System.out.println(min);
    }
}
