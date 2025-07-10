package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (input[0].equals("size")) {
                System.out.println(stack.size());
            } else if (input[0].equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input[0].equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
