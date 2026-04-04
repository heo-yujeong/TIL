package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ27708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        sb.append(T).append("\n");

        while (T-- > 0) {
            br.readLine();

            int N = Integer.parseInt(br.readLine());
            sb.append("\n");
            sb.append(N).append("\n");

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;

            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
