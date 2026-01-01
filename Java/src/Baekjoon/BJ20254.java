package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int UR = Integer.parseInt(st.nextToken());
        int TR = Integer.parseInt(st.nextToken());
        int UO = Integer.parseInt(st.nextToken());
        int TO = Integer.parseInt(st.nextToken());

        System.out.println(56 * UR + 24 * TR + 14 * UO + 6 * TO);
    }
}
