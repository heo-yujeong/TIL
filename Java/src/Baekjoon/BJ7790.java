package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ7790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        int cnt = 0;

        while ((input = br.readLine()) != null) {
            int idx = 0;
            while ((idx = input.indexOf("joke", idx)) != -1) {
                cnt++;
                idx += 4;
            }
        }

        System.out.println(cnt);
    }
}
