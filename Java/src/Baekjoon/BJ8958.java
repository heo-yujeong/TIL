package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split("");
            int sum = 0, jumsu = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("O")) {
                    jumsu++;
                    sum += jumsu;
                } else {
                    jumsu = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
