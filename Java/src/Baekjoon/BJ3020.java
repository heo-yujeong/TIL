package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H+2];
        int[] top = new int[H+2];

        for (int i = 0; i < N/2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine())+1]++;
        }

        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i-1];
        }

        for (int i = H; i >= 1; i--) {
            top[i] += top[i+1];
        }

        int min = N;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            int obstacle = (bottom[H] - bottom[i-1]) + (top[1] - top[i+1]);

            if (obstacle < min) {
                min = obstacle;
                cnt = 1;
            } else if (obstacle == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
        br.close();
    }
}
