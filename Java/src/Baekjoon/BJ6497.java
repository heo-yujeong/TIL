package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ6497 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }

            parent = new int[m+1];
            for (int i = 0; i <= m; i++) {
                parent[i] = i;
            }

            int[][] load = new int[n][3];
            int result = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                load[i][0] = Integer.parseInt(st.nextToken());
                load[i][1] = Integer.parseInt(st.nextToken());
                load[i][2] = Integer.parseInt(st.nextToken());
                result += load[i][2];
            }

            Arrays.sort(load, Comparator.comparingInt(a -> a[2]));

            int cnt = 0;
            for (int[] l : load) {
                if (find(l[0]) != find(l[1])) {
                    union(l[0], l[1]);
                    result -= l[2];
                    cnt++;
                }

                if (cnt == m-1) {
                    break;
                }
            }

            System.out.println(result);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
