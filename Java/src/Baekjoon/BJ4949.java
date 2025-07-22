package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<String> stack = new Stack<>();
            String[] sentence = str.split("");
            for (String word: sentence) {
                switch (word) {
                    case "(":
                    case "[":
                        stack.push(word);
                        break;
                    case ")":
                        if (!stack.isEmpty() && stack.peek().equals("("))
                            stack.pop();
                        else stack.push(word);
                        break;
                    case "]":
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else stack.push("]");
                        break;
                }

            }
            if (stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
