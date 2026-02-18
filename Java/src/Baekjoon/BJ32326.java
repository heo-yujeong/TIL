package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ32326 {
    static int[] cost = {3, 4, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = 0;

        for (int i = 0; i < 3; i++) {
            int cnt = Integer.parseInt(br.readLine());
            C += cnt * cost[i];
        }

        System.out.println(C);
    }
}
