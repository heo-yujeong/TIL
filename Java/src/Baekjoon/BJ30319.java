package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class BJ30319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LocalDate contestDate = LocalDate.parse(br.readLine());
        LocalDate deadline = LocalDate.of(2023, 9, 16);

        if (contestDate.isAfter(deadline)) {
            System.out.println("TOO LATE");
        } else {
            System.out.println("GOOD");
        }
    }
}
