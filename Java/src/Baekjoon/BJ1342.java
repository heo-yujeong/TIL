package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1342 {
    static int cnt = 0;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            alpha[S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                check((char)('a' + i) + "", S);
                alpha[i]++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static void check(String str, String input) {
        if (str.length() == input.length()) {
            cnt++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0 && str.charAt(str.length()-1) != (char)('a' + i)) {
                alpha[i]--;
                check(str + (char)('a' + i), input);
                alpha[i]++;
            }
        }
    }

}
