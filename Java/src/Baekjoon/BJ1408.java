package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] now = br.readLine().split(":");
        String[] start = br.readLine().split(":");

        int nowSec = Integer.parseInt(now[0]) * 3600
                + Integer.parseInt(now[1]) * 60
                + Integer.parseInt(now[2]);

        int startSec = Integer.parseInt(start[0]) * 3600
                + Integer.parseInt(start[1]) * 60
                + Integer.parseInt(start[2]);

        int remainSec = startSec - nowSec;
        if (remainSec <= 0) {
            remainSec += 24 * 3600;
        }

        int h = remainSec / 3600;
        int m = remainSec % 3600 / 60;
        int s = remainSec % 60;

        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }
}
