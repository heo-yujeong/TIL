package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class BJ28245 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> powers = new ArrayList<>();
        HashMap<Long, int[]> map = new HashMap<>();
        ArrayList<Long> sums = new ArrayList<>();

        for (int i = 0; i <= 60; i++) {
            powers.add(1L << i);
        }

        for (int i = 0; i < powers.size(); i++) {
            for (int j = 0; j < powers.size(); j++) {
                long sum = powers.get(i) + powers.get(j);
                if (!map.containsKey(sum)) {
                    sums.add(sum);
                    map.put(sum, new int[] {i, j});
                }
            }
        }

        Collections.sort(sums);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long M = Long.parseLong(br.readLine());
            long closetSum = -1;

            for (int j = 1; j < sums.size(); j++) {
                if (sums.get(j) > M) {
                    closetSum = (sums.get(j) - M >= M - sums.get(j-1)) ? sums.get(j-1) : sums.get(j);
                    break;
                }
            }

            int[] result = map.get(closetSum);
            System.out.println(result[0] + " " + result[1]);
        }
        br.close();
    }
}
