package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'e', 'i', 'o', 'u'};

        while (true) {
            String input = br.readLine().toLowerCase();
            if (input.equals("#")) {
                break;
            }

            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                for (char ch : arr) {
                    if (input.charAt(i) == ch) {
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
