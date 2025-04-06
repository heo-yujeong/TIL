package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1922 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int[][] network = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            network[i][0] = Integer.parseInt(st.nextToken());
            network[i][1] = Integer.parseInt(st.nextToken());
            network[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(network, Comparator.comparingInt(o -> o[2]));

        int result = 0;
        for (int[] net : network) {
            if (union(net[0], net[1])) {
                result += net[2];
            }
        }

        System.out.println(result);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
