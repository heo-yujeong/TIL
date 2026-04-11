package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        String encrypted = br.readLine();

        long off = 1;
        a %= 26;

        while (b > 0) {
            if ((b & 1) == 1) {
                off = (off * a) % 26;
            }
            a = (a * a) % 26;
            b >>= 1;
        }

        int offset = (int) off;

        for (int i = 0; i < n; i++) {
            char c = encrypted.charAt(i);

            if (c == ' ') {
                sb.append(' ');
            } else {
                int decrypted = (c - 'A' - offset + 26) % 26;
                sb.append((char) (decrypted + 'A'));
            }
        }

        System.out.println(sb);
    }
}
