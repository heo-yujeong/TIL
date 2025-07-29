package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3003 {
    static int[] pin = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[pin.length];

        for (int i = 0; i < pin.length; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            result[i] = pin[i] - cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int count: result) {
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
