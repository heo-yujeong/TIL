package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i, top});
        }
        br.close();
    }
}
