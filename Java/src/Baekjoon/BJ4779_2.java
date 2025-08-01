package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4779_2 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int len = (int) Math.pow(3, N);

            sb = new StringBuilder();

            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            cantor(0, len);
            System.out.println(sb);
        }
    }

    private static void cantor(int start, int len) {
        if (len == 1) return;
        int newLen = len / 3;

        for (int i = start + newLen; i < start + 2*newLen; i++) {
            sb.setCharAt(i,' ');
        }

        cantor(start, newLen);
        cantor(start + 2*newLen, newLen);
    }
}
