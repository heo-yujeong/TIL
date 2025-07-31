package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append("long ".repeat(Math.max(0, N / 4)));
        sb.append("int");

        System.out.println(sb);
    }
}
