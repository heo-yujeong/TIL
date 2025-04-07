package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16398 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> edge = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int C = Integer.parseInt(st.nextToken());
                if (i < j) {
                    edge.add(new int[]{i, j, C});
                }
            }
        }

        edge.sort(Comparator.comparingInt(a -> a[2]));

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        long result = 0;
        for (int[] e : edge) {
            if (find(e[0]) != find(e[1])) {
                union(e[0], e[1]);
                result += e[2];
            }
        }

        System.out.println(result);
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
