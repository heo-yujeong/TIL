package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] msg = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : msg) {
            int num = Integer.parseInt(s, 16);
            if ((num & 0b01100000) == 0b1000000)
                sb.append("-");
            else
                sb.append(".");
        }

        System.out.println(sb);
        br.close();
    }
}
