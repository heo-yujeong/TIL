package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());

        System.out.println(first * (second % 10));
        System.out.println(first * (second % 100 / 10));
        System.out.println(first * (second / 100));
        System.out.println(first * second);
    }
}
