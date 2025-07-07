package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int jumsu = Integer.parseInt(br.readLine());

        if (jumsu >= 90) {
            System.out.println("A");
        } else if (jumsu >= 80) {
            System.out.println("B");
        } else if (jumsu >= 70) {
            System.out.println("C");
        } else if (jumsu >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
