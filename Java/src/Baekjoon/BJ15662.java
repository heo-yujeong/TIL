package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ15662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] wheel = new LinkedList[T+1];

        for (int i = 1; i <= T; i++) {
            String input = br.readLine();
            wheel[i] = new LinkedList<>();
            for (int j = 0; j < input.length(); j++) {
                wheel[i].add(input.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            boolean[] visit = new boolean[T+1];
            int[] rotateDir = new int[T+1];
            rotateDir[num] = dir;
            visit[num] = true;

            for (int j = num; j < T; j++) {
                if (wheel[j].get(2) != wheel[j+1].get(6)) {
                    rotateDir[j+1] = -rotateDir[j];
                    visit[j+1] = true;
                } else break;
            }

            for (int j = num; j > 1; j--) {
                if (wheel[j].get(6) != wheel[j-1].get(2)) {
                    rotateDir[j-1] = -rotateDir[j];
                    visit[j-1] = true;
                } else break;
            }

            for (int j = 1; j <= T; j++) {
                if (visit[j]) {
                    if (rotateDir[j] == 1) {
                        wheel[j].addFirst(wheel[j].removeLast());
                    } else if (rotateDir[j] == -1) {
                        wheel[j].addLast(wheel[j].removeFirst());
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= T; i++) {
            if (wheel[i].get(0) == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
