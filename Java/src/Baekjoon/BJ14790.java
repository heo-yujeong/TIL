package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String N = br.readLine();
            char[] charN = N.toCharArray();

            int at = charN.length;

            for (int i = charN.length - 1; i > 0; i--) {
                if (charN[i] < charN[i - 1]) {
                    charN[i-1]--;
                    at = i;
                }
            }

            for (int i = at; i < charN.length; i++) {
                charN[i] = '9';
            }

            String result = new String(charN).replaceFirst("^0+", "");
            sb.append("Case #").append(t).append(": ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}
