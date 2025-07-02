package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxIdx = 0;
        int maxNum = 0;

        for (int i = 1; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > maxNum) {
                maxNum = n;
                maxIdx = i;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxIdx);
    }
}
