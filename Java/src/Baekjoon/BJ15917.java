package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            int a = Integer.parseInt(br.readLine());

            if ((a & (a * -1)) == a) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
