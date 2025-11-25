package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
            people[i][2] = Integer.parseInt(st.nextToken());
        }

        int best = 0;
        for (int i = 1; i < N; i++) {
            int[] people1 = people[best];
            int[] people2 = people[i];

            if (people2[0] > people1[0]
                    || people2[0] == people1[0] && people2[1] < people1[1]
                    || people2[0] == people1[0] && people2[1] == people1[1] && people2[2] < people1[2]) {
                best = i;
            }
        }

        System.out.println(best + 1);
    }
}
