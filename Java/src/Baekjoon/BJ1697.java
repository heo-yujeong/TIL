package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {
    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                return visit[now] - 1;
            }
            if (now-1 >= 0 && visit[now-1] == 0) {
                queue.add(now-1);
                visit[now-1] = visit[now] + 1;
            }
            if (now+1 <= 100000 && visit[now+1] == 0) {
                queue.add(now+1);
                visit[now+1] = visit[now] + 1;
            }
            if (now*2 <= 100000 && visit[now*2] == 0) {
                queue.add(now*2);
                visit[now*2] = visit[now] + 1;
            }
        }

        return -1;
    }
}
