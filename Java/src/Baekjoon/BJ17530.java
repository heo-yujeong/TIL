package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int Carlos = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v > Carlos) {
                System.out.println("N");
                return;
            }
        }

        System.out.println("S");
    }
}
