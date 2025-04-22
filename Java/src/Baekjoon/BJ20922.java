package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0, right = 0, result = 0;
        while (left <= right) {
            if (right < N && cnt[nums[right]] < K) {
                cnt[nums[right]]++;
                right++;
            } else if (right < N && cnt[nums[right]] == K) {
                cnt[nums[left]]--;
                left++;
            } else {
                result = Math.max(result, right - left);
                break;
            }

            result = Math.max(result, right - left);
        }

        System.out.println(result);
    }
}
