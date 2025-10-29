package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        List<String> word = new ArrayList<>(map.keySet());
        word.sort((o1, o2) -> {
            if (map.get(o1) != map.get(o2)) {
                return map.get(o2) - map.get(o1);
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
