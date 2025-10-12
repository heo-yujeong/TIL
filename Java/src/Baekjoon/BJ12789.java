package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        String result = "Nice";

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (idx != arr[i]) {
                if (!stack.isEmpty() && stack.peek() == idx) {
                    stack.pop();
                    idx++;
                    i--;
                } else {
                    stack.push(arr[i]);
                }
            } else {
                idx++;
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == idx) {
                idx++;
            } else {
                result = "Sad";
                break;
            }
        }

        System.out.println(result);
    }
}
