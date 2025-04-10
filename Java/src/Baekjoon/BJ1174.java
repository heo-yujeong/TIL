package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ1174 {
    static int[] digit = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lst = new ArrayList<>();

        backtrack(0, 0);
        Collections.sort(lst);

        if (N > lst.size()) {
            System.out.println(-1);
        } else {
            System.out.println(lst.get(N - 1));
        }
    }

    private static void backtrack(int idx, long num) {
        if (idx == 10) {
            if (!lst.contains(num)) {
                lst.add(num);
            }
            return;
        }

        backtrack(idx + 1, num);
        backtrack(idx + 1, num*10+digit[idx]);
    }
}
