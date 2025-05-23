package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ12873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        for (int i = 1; i < N; i++, queue.poll()) {
            long num = ((long) i * i * i -1) % queue.size();
            while (num-- > 0) {
                queue.offer(queue.poll());
            }
        }

        System.out.println(queue.poll());
        br.close();
    }
}
