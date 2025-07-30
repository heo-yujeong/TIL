package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());

        A += (C / 60);
        B += (C % 60);

        if (B >= 60) {
            A += 1;
            B -= 60;
        }

        if (A > 24) {
            A -= 24;
        } else if (A == 24) {
            A = 0;
        }

        System.out.println(A + " " + B);
    }
}
