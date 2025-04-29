package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        int[] car = new int[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            car[i] = map.get(input);
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (car[i] > car[j]) {
                    result += 1;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
