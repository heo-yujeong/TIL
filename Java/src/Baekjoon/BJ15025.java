package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if (l == r) {
            if (l == 0) {
                System.out.println("Not a moose");
            } else {
                System.out.println("Even " + 2 * l);
            }
        } else if (l > r) {
            System.out.println("Odd " + 2 * l);
        } else {
            System.out.println("Odd " + 2 * r);
        }
    }
}
