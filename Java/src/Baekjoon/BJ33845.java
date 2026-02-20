package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ33845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String T = br.readLine();

        Set<Character> set = new HashSet<>();
        for (char c : S.toCharArray()) {
            set.add(c);
        }

        for (char c : T.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
