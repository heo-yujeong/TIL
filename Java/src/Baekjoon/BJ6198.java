package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= h[i]) {
                stack.pop();
            }

            stack.push(h[i]);
            result += stack.size() - 1;
        }

        System.out.println(result);
    }
}
