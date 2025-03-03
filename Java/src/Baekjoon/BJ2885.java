package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int minSize = 1;
        while (minSize < K) {
            minSize <<= 1;
        }

        int minCut = 0;
        int curSize = minSize;
        while (K > 0) {
            if (K >= curSize) {
                K -= curSize;
            } else {
                curSize >>= 1;
                minCut++;
            }
        }

        System.out.println(minSize + " " + minCut);
        br.close();
    }
}
