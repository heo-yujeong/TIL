package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        int[] sortX = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = sortX[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortX);

        int rank = 0;
        for (int x : sortX) {
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : X) {
            sb.append(rankMap.get(x)).append(" ");
        }

        System.out.println(sb);
    }
}
