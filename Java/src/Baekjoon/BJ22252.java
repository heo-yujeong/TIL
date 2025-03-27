package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long total = 0;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if (type == 1) {
                if (!map.containsKey(name)) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                    for (int j = 0; j < k; j++) {
                        pq.add(Integer.parseInt(st.nextToken()));
                    }
                    map.put(name, pq);
                } else {
                    for (int j = 0; j < k; j++) {
                        map.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                }
            } else {
                if (map.containsKey(name)) {
                    PriorityQueue<Integer> pq = map.get(name);
                    int cnt = pq.size() < k ? pq.size() : k;
                    for (int j = 0; j < cnt; j++) {
                        total += pq.poll();
                    }
                }
            }
        }

        System.out.println(total);
    }
}
