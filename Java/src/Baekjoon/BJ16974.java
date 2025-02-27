package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        System.out.println(cntPat(N, X));
    }

    private static long cntPat(int N, long X) {
        if (N == 0)
            return 1;

        long total = (1L << (N+2)) - 3;
        long pat = (1L << (N+1)) - 1;

        if (X == 1)
            return 0;
        if (X <= total / 2)
            return cntPat(N-1, X-1);
        if (X == total / 2 + 1)
            return pat / 2 + 1;
        if (X <= total)
            return pat / 2 + 1 + cntPat(N-1, X-(total/2+1));

        return pat;
    }
}
