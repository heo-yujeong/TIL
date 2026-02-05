package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ33541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        for (int year = X+1; year <= 9999; year++) {
            int front = year / 100;
            int back = year % 100;
            int sum = front + back;

            if (sum * sum == year) {
                System.out.println(year);
                return;
            }
        }

        System.out.println(-1);
    }
}
