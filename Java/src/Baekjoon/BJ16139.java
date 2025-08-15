package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        int[][] arr = new int[S.length()+1][26];

        for (int i = 1; i <= S.length(); i++) {
            int val = S.charAt(i-1) - 'a';
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i-1][j] + (val == j ? 1 : 0);
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(arr[r+1][a] - arr[l][a]).append("\n");
        }

        System.out.println(sb);
    }
}
