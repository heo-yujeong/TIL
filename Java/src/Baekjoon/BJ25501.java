package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25501 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String S = br.readLine();
            cnt = 0;
            System.out.println(isPalindrome(S) + " " + cnt);
        }
    }

    private static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

    private static int recursion(String s, int left, int right) {
        cnt++;

        if (left >= right) {
            return 1;
        } else if (s.charAt(left) != s.charAt(right)) {
            return 0;
        } else {
            return recursion(s, left + 1, right - 1);
        }
    }
}
