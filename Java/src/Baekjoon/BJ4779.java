package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4779 {
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

            splitStr(0, len);
            System.out.println(sb);
        }
    }

    private static void splitStr(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        for (int i = start+newSize; i < start+2*newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        splitStr(start, newSize);
        splitStr(start+2*newSize, newSize);
    }
}
