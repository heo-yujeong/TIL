package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1351 {
    static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        System.out.println(A(N, P, Q));
        br.close();
    }

    private static long A(long N, long P, long Q) {
        if (N == 0)
            return 1;
        if (memo.containsKey(N))
            return memo.get(N);

        long result = A(N/P, P, Q) + A(N/Q, P, Q);
        memo.put(N, result);
        return result;
    }
}
