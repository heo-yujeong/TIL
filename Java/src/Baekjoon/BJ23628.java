package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int SYear = Integer.parseInt(st.nextToken());
        int SMonth = Integer.parseInt(st.nextToken());
        int SDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int EYear = Integer.parseInt(st.nextToken());
        int EMonth = Integer.parseInt(st.nextToken());
        int EDay = Integer.parseInt(st.nextToken());

        int total = (EYear - SYear) * 360 + (EMonth - SMonth) * 30 + (EDay - SDay);
        int month = Math.min(total / 30, 36);

        int year = 0;
        for (int i = 1; i <= total/360; i++) {
            int tmp = (i - 1) / 2;
            year += tmp + 15;
        }

        System.out.println(year + " " + month);
        System.out.println(total + "days");
    }
}
