package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17103 {
    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[1000001];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i < 1000001; i++) {
            if (!arr[i]) {
                for (int j = i+i; j < 1000001; j+=i) {
                    arr[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int res = 0;

            for (int i = 2; i <= N/2; i++) {
                if (!arr[i] && !arr[N-i]) {
                    res++;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
