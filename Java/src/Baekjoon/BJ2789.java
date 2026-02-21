package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class BJ2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String delWord = "CAMBRIDGE";
        Set<Character> set = delWord.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        String input = br.readLine();
        for (char c : input.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
