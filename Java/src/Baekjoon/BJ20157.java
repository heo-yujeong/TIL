package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ20157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = Math.abs(GCD(x, y));
            String slope = y/gcd + "/" + x/gcd;
            map.put(slope, map.getOrDefault(slope, 0) + 1);
            result = Math.max(result, map.get(slope));
        }

        System.out.println(result);
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
