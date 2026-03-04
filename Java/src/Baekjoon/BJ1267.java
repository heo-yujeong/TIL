package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ys = 0, ms = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            ys += ((n / 30) + 1) * 10;
            ms += ((n / 60) + 1) * 15;
        }

        if (ys > ms) {
            System.out.println("M " + ms);
        } else if (ys < ms) {
            System.out.println("Y " + ys);
        } else {
            System.out.println("Y M " +ys);
        }
    }
}
