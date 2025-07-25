package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int chk = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '*') {
                num += i % 2 == 0 ? ch-'0': (ch-'0') * 3;
            } else {
                chk = i;
            }
        }

        int result = 0;
        while (true) {
            if (chk % 2 == 0) {
                if ((num + result) % 10 == 0) {
                    System.out.println(result);
                    break;
                }
            } else {
                if ((num + result * 3) % 10 == 0) {
                    System.out.println(result);
                    break;
                }
            }
            result++;
        }
    }
}
