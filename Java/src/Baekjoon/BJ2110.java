package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N-1] - house[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (check(mid) < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }

    private static int check(int dist) {
        int cnt = 1;
        int loc = house[0];

        for (int i = 1; i < house.length; i++) {
            int now = house[i];

            if (now - loc >= dist) {
                cnt++;
                loc = now;
            }
        }

        return cnt;
    }
}
