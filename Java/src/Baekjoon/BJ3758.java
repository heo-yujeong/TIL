package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3758 {
    static int[] logCnt, logLatestTime;
    static int[][] logHighScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            logCnt = new int[n];
            logLatestTime = new int[n];
            logHighScore = new int[n][k];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken()) - 1;
                int questId = Integer.parseInt(st.nextToken()) - 1;
                int score = Integer.parseInt(st.nextToken());

                logCnt[teamId]++;
                logLatestTime[teamId] = i;
                logHighScore[teamId][questId] = Math.max(logHighScore[teamId][questId], score);
            }

            int[][] sortLog = new int[n][4];
            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int s : logHighScore[i]) {
                    total += s;
                }

                sortLog[i][0] = total;
                sortLog[i][1] = logCnt[i];
                sortLog[i][2] = logLatestTime[i];
                sortLog[i][3] = i;
            }

            Arrays.sort(sortLog, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            });

            for (int i = 0; i < n; i++) {
                if (sortLog[i][3] == t-1) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
