package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long numLen = 1;
        long numCnt = 9;

        while (k > numCnt * numLen) {
            k -= numCnt * numLen;
            numLen++;
            numCnt *= 10;
        }

        k--;

        long result = (long) Math.pow(10, (numLen-1)) + (k/numLen);

        if (result > N) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(result).charAt((int) (k % numLen)));
        }
        br.close();
    }
}
