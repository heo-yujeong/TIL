package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int i = 0;
        for (char c : input) {
            if (i == 0 && c == 'U') {
                i++;
            }
            if ((i == 1 || i == 3) && c == 'C') {
                i++;
            }
            if (i == 2 && c == 'P') {
                i++;
            }
        }

        if (i == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
