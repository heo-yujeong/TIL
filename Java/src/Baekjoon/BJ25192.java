package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int cnt = 0;

        while (N-- > 0) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(input);
            }
        }

        cnt += set.size();
        System.out.println(cnt);
    }
}
