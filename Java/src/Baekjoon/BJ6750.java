package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String able = "IOSHZXN";
        boolean chk = true;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!able.contains(String.valueOf(ch))) {
                chk = false;
                break;
            }
        }

        if (chk) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
