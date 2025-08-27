package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());
            System.out.println((N+1) / 2);

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int n1 = maxHeap.poll();
                        int n2 = minHeap.poll();

                        maxHeap.add(n2);
                        minHeap.add(n1);
                    }
                }

                if (i % 2 == 0) {
                    if (cnt == 9 || i == N-1) {
                        System.out.println(maxHeap.peek());
                        cnt = 0;
                    } else {
                        System.out.print(maxHeap.peek() + " ");
                    }
                    cnt++;
                }
            }
        }
    }
}
