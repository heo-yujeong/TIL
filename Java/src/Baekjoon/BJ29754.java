package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ29754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int week = M / 7;

        Map<String, int[][]> broadcast = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int duration = endTime - startTime;

            int weekIdx = (day - 1) / 7;

            broadcast.computeIfAbsent(name, k -> new int[week][2]);
            broadcast.get(name)[weekIdx][0] += 1;
            broadcast.get(name)[weekIdx][1] += duration;
        }

        List<String> realVT = new ArrayList<>();
        for (Map.Entry<String, int[][]> entry : broadcast.entrySet()) {
            String name = entry.getKey();
            int[][] weekData = entry.getValue();
            boolean isReal = true;

            for (int[] wd : weekData) {
                int cnt = wd[0];
                int time = wd[1];
                if (cnt < 5 || time < 3600) {
                    isReal = false;
                    break;
                }
            }

            if (isReal) {
                realVT.add(name);
            }
        }

        if (realVT.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(realVT);
            for (String name : realVT) {
                System.out.println(name);
            }
        }
    }
}
