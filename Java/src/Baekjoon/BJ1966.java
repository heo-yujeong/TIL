package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (now[1] < queue.get(i)[1]) {
                        queue.offer(now);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if (!isMax) continue;

                cnt++;
                if (now[0] == M) {
                    break;
                }
            }

            System.out.println(cnt);
        }
    }
}
