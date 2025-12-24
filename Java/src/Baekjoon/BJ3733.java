package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            System.out.println(S / (N + 1));
        }
    }
}
