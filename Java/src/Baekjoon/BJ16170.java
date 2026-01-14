package Baekjoon;

import java.time.LocalDate;

public class BJ16170 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println(today.getYear());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfMonth());
    }
}
