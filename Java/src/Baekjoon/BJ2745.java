package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int exp = Integer.parseInt(st.nextToken());

        int tmp = 1;
        int sum = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char chr = str.charAt(i);

            if (chr >= 'A' && chr <= 'Z') {
                sum += (chr - 'A' + 10) * tmp;
            } else {
                sum += (chr - '0') * tmp;
            }

            tmp *= exp;
        }

        System.out.println(sum);
    }
}
