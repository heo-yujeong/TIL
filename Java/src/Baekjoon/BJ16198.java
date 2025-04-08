package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16198 {
    static List<Integer> energy;
    static int power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        energy = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy.add(Integer.parseInt(st.nextToken()));
        }

        backtrack(N, 0);
        System.out.println(power);
    }

    private static void backtrack(int cnt, int hap) {
        if (cnt == 2) {
            power = Math.max(hap, power);
            return;
        }

        for (int i = 1; i < cnt-1; i++) {
            int e = energy.get(i-1) * energy.get(i+1);
            int tmp = energy.remove(i);
            backtrack(cnt-1, hap+e);
            energy.add(i, tmp);
        }
    }
}
