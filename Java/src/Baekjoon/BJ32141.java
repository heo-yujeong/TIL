package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ32141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int d = Integer.parseInt(st.nextToken());
            cnt++;
            H -= d;

            if (H <= 0) {
                break;
            }
        }

        System.out.println(H > 0 ? -1 : cnt);
    }
}
