package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ18813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Set<Character> set = new HashSet<>();
            boolean isValid = true;

            for (char c : word.toCharArray()) {
                if (c - 'A' >= m) {
                    isValid = false;
                    break;
                }

                if (set.contains(c)) {
                    isValid = false;
                    break;
                }

                set.add(c);
            }

            if (isValid) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
