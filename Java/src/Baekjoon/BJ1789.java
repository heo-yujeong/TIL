package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0L;
        int cnt = 0;

        while (true) {
            cnt++;
            sum += cnt;

            if (sum > S) {
                cnt--;
                break;
            }
        }

        System.out.println(cnt);
    }
}
