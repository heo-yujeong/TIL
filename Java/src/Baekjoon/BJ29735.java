package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ29735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String startTime = st.nextToken();
        String endTime = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(startTime, ":");
        int startHour = Integer.parseInt(st.nextToken());
        int startMinute = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(endTime, ":");
        int endHour = Integer.parseInt(st.nextToken());
        int endMinute = Integer.parseInt(st.nextToken());

        int start = startHour * 60 + startMinute;
        int end = endHour * 60 + endMinute;
        int total = end - start;

        int perDay = (total - 1) / T;
        int day = N / perDay;
        int arrive = start + (N % perDay + 1) * T;

        System.out.println(day);
        int h = arrive / 60;
        int m = arrive % 60;

        String hh = (h < 10 ? "0" : "") + h;
        String mm = (m < 10 ? "0" : "") + m;

        System.out.println(hh + ":" + mm);
    }
}
