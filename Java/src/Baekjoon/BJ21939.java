package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeSet<int[]> sortedProblem = new TreeSet<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        Map<Integer, Integer> problemLevel = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            sortedProblem.add(new int[] {P, L});
            problemLevel.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    int[] problem = (x == 1)? sortedProblem.last() : sortedProblem.first();
                    System.out.println(problem[0]);
                    break;

                case "add":
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    sortedProblem.add(new int[] {P, L});
                    problemLevel.put(P, L);
                    break;

                case "solved":
                    int p = Integer.parseInt(st.nextToken());
                    int level = problemLevel.get(p);
                    sortedProblem.remove(new int[] {p, level});
                    problemLevel.remove(p);
                    break;
            }
        }
    }
}
