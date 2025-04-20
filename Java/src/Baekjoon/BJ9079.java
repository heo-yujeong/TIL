package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9079 {
    static int[][] ops = {
            {7, 0, 0},
            {0, 7, 0},
            {0, 0, 7},

            {4, 4, 4},
            {2, 2, 2},
            {1, 1, 1},

            {4, 2, 1},
            {1, 2, 4}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] start = new int[3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    String s = st.nextToken();
                    if (s.equals("H")) {
                        start[i] |= 1 << (2 - j);
                    }
                }
            }
            System.out.println(bfs(start));
        }
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[8][8][8];

        queue.add(new int[]{start[0], start[1], start[2], 0});
        visit[start[0]][start[1]][start[2]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now1 = now[0], now2 = now[1], now3 = now[2], depth = now[3];

            if ((now1 == 0 && now2 == 0 && now3 == 0) || (now1 == 7 && now2 == 7 && now3 == 7)) {
                return depth;
            }

            for (int[] op : ops) {
                int next1 = now1 ^ op[0];
                int next2 = now2 ^ op[1];
                int next3 = now3 ^ op[2];

                if (!visit[next1][next2][next3]) {
                    visit[next1][next2][next3] = true;
                    queue.add(new int[]{next1, next2, next3, depth + 1});
                }
            }
        }

        return -1;
    }
}
