package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (order == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (order == 3) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.removeFirst()).append("\n");
                }
            } else if (order == 4) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.removeLast()).append("\n");
                }
            } else if (order == 5) {
                sb.append(deque.size()).append("\n");
            } else if (order == 6) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (order == 7) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            } else if (order == 8) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
