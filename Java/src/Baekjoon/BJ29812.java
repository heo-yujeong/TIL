package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ29812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int energy = 0;
        int cntH = 0, cntY = 0, cntU = 0;
        int delLen = 0;

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == 'H' || c == 'Y' || c == 'U') {
                if (c == 'H') cntH++;
                else if (c == 'Y') cntY++;
                else cntU++;

                if (delLen > 0) {
                    energy += Math.min(delLen * D, D + M);
                    delLen = 0;
                }
            } else {
                delLen++;
            }
        }

        if (delLen > 0) {
            energy += Math.min(delLen * D, D + M);
        }

        int hyuCnt = Math.min(cntH, Math.min(cntY, cntU));

        System.out.println(energy == 0 ? "Nalmeok" : energy);
        System.out.println(hyuCnt == 0 ? "I love HanYang University" : hyuCnt);
    }
}
