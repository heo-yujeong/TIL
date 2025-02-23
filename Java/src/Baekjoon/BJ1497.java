package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1497 {
    static int N, M;
    static int maxSongCnt = 0;
    static int minGuitarCnt = Integer.MAX_VALUE;
    static long[] guitarBitmask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitarBitmask = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] guitarChars = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (guitarChars[j] == 'Y') {
                    guitarBitmask[i] |= (1L << j);
                }
            }
        }

        backtrack(0, 0L, 0);

        if (minGuitarCnt == 0) {
            minGuitarCnt = -1;
        }

        System.out.println(minGuitarCnt);
        br.close();
    }

    private static void backtrack(int idx, long playSongMask, int guitarCnt) {
        int playCnt = Long.bitCount(playSongMask);

        if (playCnt == maxSongCnt && guitarCnt < minGuitarCnt) {
            minGuitarCnt = guitarCnt;
        }

        if (playCnt > maxSongCnt) {
            minGuitarCnt = guitarCnt;
            maxSongCnt = playCnt;
        }

        if (playCnt == M || idx == N) {
            return;
        }

        backtrack(idx+1, playSongMask | guitarBitmask[idx], guitarCnt +1);
        backtrack(idx+1, playSongMask, guitarCnt);
    }
}
