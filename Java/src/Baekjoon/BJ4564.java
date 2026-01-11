package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String S = br.readLine();
            if (S.equals("0")) break;

            while (S.length() > 1) {
                int tmp = 1;
                sb.append(S).append(" ");

                for (char c : S.toCharArray()) {
                    tmp *= (c - '0');
                }

                S = String.valueOf(tmp);
            }

            sb.append(S).append("\n");
        }

        System.out.println(sb);
    }
}
