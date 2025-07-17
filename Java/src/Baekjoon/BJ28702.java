package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 3; i > 0; i--) {
            String input = br.readLine();
            if (input.matches("^[0-9]*$")) {
                int num = Integer.parseInt(input) + i;
                if (num % 3 == 0) {
                    if (num % 5 == 0) {
                        System.out.println("FizzBuzz");
                        return;
                    } else {
                        System.out.println("Fizz");
                        return;
                    }
                } else if (num % 5 == 0) {
                    System.out.println("Buzz");
                    return;
                } else {
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}
