package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double total = 0;
        double totalJumsu = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double jumsu = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            switch (grade) {
                case "A+":
                    total += jumsu;
                    totalJumsu += (jumsu * 4.5);
                    break;
                case "A0":
                    total += jumsu;
                    totalJumsu += (jumsu * 4.0);
                    break;
                case "B+":
                    total += jumsu;
                    totalJumsu += (jumsu * 3.5);
                    break;
                case "B0":
                    total += jumsu;
                    totalJumsu += (jumsu * 3.0);
                    break;
                case "C+":
                    total += jumsu;
                    totalJumsu += (jumsu * 2.5);
                    break;
                case "C0":
                    total += jumsu;
                    totalJumsu += (jumsu * 2.0);
                    break;
                case "D+":
                    total += jumsu;
                    totalJumsu += (jumsu * 1.5);
                    break;
                case "D0":
                    total += jumsu;
                    totalJumsu += jumsu;
                    break;
                default:
                    total += jumsu;
                    break;
            }
        }

        System.out.println(totalJumsu / total);
    }
}
