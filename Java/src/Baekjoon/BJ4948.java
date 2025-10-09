package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[256913];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i * i <= 256912; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= 256912; j += i) {
                    arr[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int cnt = 0;

            for (int i = n+1; i <= 2*n; i++) {
                if (!arr[i]) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
