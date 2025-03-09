package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> lionList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int dollNum = Integer.parseInt(st.nextToken());
            if (dollNum == 1) {
                lionList.add(i);
            }
        }

        if (lionList.size() < K) {
            System.out.println(-1);
        } else {
            int result = Integer.MAX_VALUE;

            for (int i = 0; i <= lionList.size() - K; i++) {
                int left = lionList.get(i);
                int right = lionList.get(i+K-1);
                result = Math.min(result, right-left+1);
            }
            System.out.println(result);
        }
        br.close();
    }
}
