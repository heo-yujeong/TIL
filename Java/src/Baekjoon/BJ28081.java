package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ28081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        long[] y = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            y[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] x = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        List<Long> blockH = new ArrayList<>();
        Arrays.sort(y);
        blockH.add(y[0]);
        for (int i = 1; i < N; i++) {
            blockH.add(y[i] - y[i - 1]);
        }
        blockH.add(H - y[N - 1]);

        List<Long> blockW = new ArrayList<>();
        Arrays.sort(x);
        blockW.add(x[0]);
        for (int i = 1; i < M; i++) {
            blockW.add(x[i] - x[i - 1]);
        }
        blockW.add(W - x[M - 1]);

        Collections.sort(blockW);

        long cnt = 0;
        for (long h : blockH) {
            long maxW = K / h;
            int left = 0, right = blockW.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (blockW.get(mid) <= maxW) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            cnt += left;
        }

        System.out.println(cnt);
    }
}
