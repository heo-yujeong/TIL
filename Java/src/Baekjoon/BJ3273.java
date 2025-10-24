package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int start = 0;
        int end = n-1;
        int cnt = 0;

        while (start < end) {
            int hap = a[start] + a[end];
            if (hap > x) {
                end--;
            } else if (hap < x) {
                start++;
            } else {
                cnt++;
                start++;
                end--;
            }
        }

        System.out.println(cnt);
    }
}
