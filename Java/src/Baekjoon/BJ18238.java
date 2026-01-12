package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ18238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char now = 'A';
        int time = 0;

        for (int i = 0; i < input.length(); i++) {
            int tmp = Math.abs(input.charAt(i) - now);
            time += Math.min(tmp, 26-tmp);
            now = input.charAt(i);
        }

        System.out.println(time);
    }
}
