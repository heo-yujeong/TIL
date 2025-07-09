package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            boolean flag = true;
            for (int i = 0; i < s.length()/2; i++) {
                if (s.charAt(i) != s.charAt(s.length()-i-1)) flag = false;
            }

            if (flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
