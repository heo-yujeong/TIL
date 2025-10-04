package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push(input.charAt(i));
                } else if (stack.isEmpty()) {
                    isValid = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
