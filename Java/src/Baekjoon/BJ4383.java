package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4383 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());

            if (n == 1) {
                System.out.println("Jolly");
                continue;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] chk = new boolean[n];
            boolean isJolly = true;

            for (int i = 1; i < n; i++) {
                int diff = Math.abs(arr[i] - arr[i-1]);

                if (diff == 0 || diff >= n) {
                    isJolly = false;
                    break;
                }

                chk[diff] = true;
            }

            for (int i = 1; i < n; i++) {
                if (!chk[i]) {
                    isJolly = false;
                    break;
                }
            }

            System.out.println(isJolly ? "Jolly" : "Not jolly");
        }
    }
}
