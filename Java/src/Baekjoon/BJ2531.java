package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] eat = new int[d+1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (eat[sushi[i]] == 0) {
                cnt++;
            }
            eat[sushi[i]]++;
        }

        int maxLen = cnt;
        for (int i = 0; i < N; i++) {
            if (maxLen <= cnt) {
                if (eat[c] == 0) {
                    maxLen = cnt + 1;
                } else {
                    maxLen = cnt;
                }
            }

            eat[sushi[i]]--;

            if (eat[sushi[i]] == 0) {
                cnt--;
            }

            if (eat[sushi[(i+k)%N]] == 0) {
                cnt++;
            }
            eat[sushi[(i+k)%N]]++;
        }

        System.out.println(maxLen);
        br.close();
    }
}
