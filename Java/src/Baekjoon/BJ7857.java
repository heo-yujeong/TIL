package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ7857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        int totalLen = A.length();

        for (int i = 1; i < N; i++) {
            String An = br.readLine();

            int j = 0;
            int len = Math.min(A.length(), An.length());

            for (int k = 0; k < len; k++) {
                if (A.charAt(k) == An.charAt(k)) {
                    j++;
                } else {
                    break;
                }
            }

            totalLen += 1 + (An.length() - j);
            A = An;
        }

        System.out.println(totalLen);
    }
}
