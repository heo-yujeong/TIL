package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ14792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.add(N);

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < K; i++) {
                int len = pq.poll();

                max = len / 2;
                min = (len - 1) / 2;

                pq.add(max);
                pq.add(min);
            }

            System.out.println("Case #" + t + ": " + max + " " + min);
        }
    }
}
