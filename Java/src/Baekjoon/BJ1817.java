package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] book = new int[N];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            book[i] = Integer.parseInt(st.nextToken());
        }

        int box = 1;
        int weight = 0;

        for (int i = 0; i < N; i++) {
            weight += book[i];
            if (weight > M) {
                box++;
                weight = book[i];
            }
        }

        System.out.println(box);
    }
}
