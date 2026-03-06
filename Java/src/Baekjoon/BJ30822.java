package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ30822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int u = 0, o = 0, s = 0, p = 0, c = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'u') u++;
            else if (ch == 'o') o++;
            else if (ch == 's') s++;
            else if (ch == 'p') p++;
            else if (ch == 'c') c++;
        }

        System.out.println(Math.min(u, Math.min(o, Math.min(s, Math.min(p, c)))));
    }
}
