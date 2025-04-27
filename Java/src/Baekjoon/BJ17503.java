package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new PriorityQueue<>();
        List<int[]> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers.add(new int[] {v, c});
        }

        beers.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        int total = 0;
        int result = -1;

        for (int[] beer : beers) {
            queue.add(beer[0]);
            total += beer[0];

            if (queue.size() > N) {
                total -= queue.poll();
            }

            if (queue.size() == N && total >= M) {
                result = beer[1];
                break;
            }
        }

        System.out.println(result);
    }
}
