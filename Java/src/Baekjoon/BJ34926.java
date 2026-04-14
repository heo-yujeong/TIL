package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ34926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        char[] map = new char[N];
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            map[i] = s.charAt(i);
        }

        int[] dx = {1, K};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visit[0] = true;
        boolean isAble = false;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == N - 1) {
                isAble = true;
                break;
            }

            for (int d = 0; d < 2; d++) {
                int next = now + dx[d];
                if (next < N && map[next] != '#' && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }

        System.out.println(isAble ? "YES" : "NO");
    }
}
