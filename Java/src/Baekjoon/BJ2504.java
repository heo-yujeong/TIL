package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stack = new Stack<>();

        boolean flag = true;
        int result = 0;
        int cnt = 1;

        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));

            switch (s) {
                case "(":
                    stack.push("(");
                    cnt *= 2;
                    break;

                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        flag = false;
                        break;
                    }

                    if (str.charAt(i-1) == '(') {
                        result += cnt;
                    }

                    stack.pop();
                    cnt /= 2;
                    break;

                case "[":
                    stack.push("[");
                    cnt *= 3;
                    break;

                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        flag = false;
                        break;
                    }

                    if (str.charAt(i-1) == '[') {
                        result += cnt;
                    }

                    stack.pop();
                    cnt /= 3;
                    break;

                default:
                    flag = false;
                    break;
            }
        }

        System.out.println((!flag || !stack.isEmpty()) ? 0 : result);
        br.close();
    }
}
