package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2817 {
    static int N, K;
    static int[] nums;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            dfs(0, 0);
            System.out.println("#" + t + " " + cnt);
        }
        br.close();
    }

    private static void dfs(int idx, int hap) {
        if (hap == K) {
            cnt++;
            return;
        }

        if (idx >= N || hap > K)
            return;

        dfs(idx+1, hap+nums[idx]);
        dfs(idx+1, hap);
    }
}
