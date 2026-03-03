package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int curStart = 0;
        int curLen = s.length();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            curStart += start;
            curLen = length;
        }

        System.out.println(s.substring(curStart, curStart + curLen));
    }
}
