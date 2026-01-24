package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int X1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());

        for (int a = 0; a < m; a++) {
            for (int c = 0; c < m; c++) {
                if ((a * seed + c) % m == X1 && (a * X1 + c) % m == X2) {
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }
    }
}
