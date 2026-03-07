package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            double N = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double M = Double.parseDouble(st.nextToken());

            int year = 0;
            while (true) {
                if (N >= M) {
                    break;
                }

                N += N * (B / 100);
                year++;
            }

            System.out.println(year);
        }
    }
}
