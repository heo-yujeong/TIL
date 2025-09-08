package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int diagonal = 1;
        int prevSum = 0;

        while (true) {
            if (X <= diagonal + prevSum) {
                if (diagonal % 2 == 0) {
                    System.out.println((X - prevSum) + "/" + (diagonal - (X - prevSum - 1)));
                    break;
                } else {
                    System.out.println((diagonal - (X - prevSum - 1)) + "/" + (X - prevSum));
                    break;
                }
            } else {
                prevSum += diagonal;
                diagonal++;
            }
        }
    }
}
