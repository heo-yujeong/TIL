package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length; i++) {
            String s = input[i];

            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (input[i-1].equals("(")) {
                    stack.pop();
                    result += stack.size();
                } else {
                    result++;
                    stack.pop();
                }
            }
        }

        System.out.println(result);
    }
}
