package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(1).append(" ");
        int move = arr[0];

        for (int i = 1; i < N; i++) {
            deque.add(new int[]{i+1, arr[i]});
        }

        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.add(deque.poll());
                }

                int[] next = deque.poll();
                sb.append(next[0]).append(" ");
                move = next[1];
            } else {
                for (int i = 1; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] next = deque.pollLast();
                sb.append(next[0]).append(" ");
                move = next[1];
            }
        }

        System.out.println(sb);
    }
}
