package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        X = Rev(X);
        Y = Rev(Y);

        System.out.println(Rev(X + Y));
    }

    private static int Rev(int N) {
        StringBuilder sb = new StringBuilder(String.valueOf(N));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
