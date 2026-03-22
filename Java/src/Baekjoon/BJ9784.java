package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9784 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] eggs = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                eggs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(eggs);

            int cnt = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                if (cnt + 1 <= P && sum + eggs[i] <= Q) {
                    sum += eggs[i];
                    cnt++;
                } else {
                    break;
                }
            }

            System.out.println("Case " + t + ": " + cnt);
        }
    }
}
