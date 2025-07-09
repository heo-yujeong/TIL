package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");

            if (order[0].equals("push")) {
                queue.offer(Integer.parseInt(order[1]));
                last = Integer.parseInt(order[1]);
            } else if (order[0].equals("pop")) {
                if (!queue.isEmpty()) System.out.println(queue.poll());
                else System.out.println(-1);
            } else if (order[0].equals("size")) {
                System.out.println(queue.size());
            } else if (order[0].equals("empty")) {
                if (queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (order[0].equals("front")) {
                if (!queue.isEmpty()) System.out.println(queue.peek());
                else System.out.println(-1);
            } else if (order[0].equals("back")) {
                if (!queue.isEmpty()) System.out.println(last);
                else System.out.println(-1);
            }
        }
    }
}
