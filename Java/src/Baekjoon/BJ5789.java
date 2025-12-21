package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String input = br.readLine();
            if (input.charAt(input.length()/2 - 1) == input.charAt(input.length()/2)) {
                System.out.println("Do-it");
            } else {
                System.out.println("Do-it-Not");
            }
        }
    }
}
