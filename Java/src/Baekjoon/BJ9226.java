package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BJ9226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;

        while (!Objects.equals(input = br.readLine(), "#")) {
            Queue<Character> queue = new LinkedList<>();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                    sb.append(input.substring(i));
                    break;
                } else {
                    queue.offer(input.charAt(i));
                }
            }

            while (!queue.isEmpty()) {
                sb.append(queue.poll());
            }

            sb.append("ay").append("\n");
        }

        System.out.println(sb);
    }
}
