package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ18428 {
    static int N;
    static char[][] corridor;
    static ArrayList<int[]> teacher;
    static boolean isPossible;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        corridor = new char[N][N];
        teacher = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                corridor[i][j] = st.nextToken().charAt(0);
                if (corridor[i][j] == 'T') {
                    teacher.add(new int[]{i, j});
                }
            }
        }

        backtrack(0, 0);
        System.out.println(isPossible ? "YES" : "NO");
    }

    private static void backtrack(int cnt, int start) {
        if (isPossible) return;

        if (cnt == 3) {
            boolean safe = true;

            for (int[] t : teacher) {
                for (int d = 0; d < 4; d++) {
                    int x = t[1];
                    int y = t[0];
                    while (true) {
                        x += dx[d];
                        y += dy[d];
                        if (x < 0 || y < 0 || x >= N || y >= N) break;
                        if (corridor[y][x] == 'O') break;
                        if (corridor[y][x] == 'S') {
                            safe = false;
                            break;
                        }
                    }
                    if (!safe) break;
                }
                if (!safe) break;
            }

            if (safe) {
                isPossible = true;
            }
            return;
        }

        for (int idx = start; idx < N*N; idx++) {
            int x = idx / N;
            int y = idx % N;

            if (corridor[y][x] == 'X') {
                corridor[y][x] = 'O';
                backtrack(cnt+1, idx+1);
                corridor[y][x] = 'X';
            }
        }
    }
}
