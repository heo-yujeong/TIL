package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (check(input)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean check(String input) {
        boolean[] check = new boolean[26];
        int prev = 0;

        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i);

            if (prev != now) {
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
