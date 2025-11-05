package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> fruit = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            fruit.put(S[right], fruit.getOrDefault(S[right], 0) + 1);

            while (fruit.size() > 2) {
                fruit.put(S[left], fruit.get(S[left]) - 1);

                if (fruit.get(S[left]) == 0) {
                    fruit.remove(S[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
