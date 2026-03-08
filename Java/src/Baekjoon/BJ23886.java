package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();

        int prevDiff = X.charAt(1) - X.charAt(0);
        if (prevDiff < 0 || prevDiff == 0) {
            System.out.println("NON ALPSOO");
            return;
        }

        for (int i = 2; i < X.length(); i++) {
            int curDiff = X.charAt(i) - X.charAt(i-1);

            if (curDiff == 0 || (prevDiff * curDiff > 0 && prevDiff != curDiff)) {
                System.out.println("NON ALPSOO");
                return;
            }

            prevDiff = curDiff;
        }

        if (prevDiff > 0) {
            System.out.println("NON ALPSOO");
        } else {
            System.out.println("ALPSOO");
        }
    }
}
