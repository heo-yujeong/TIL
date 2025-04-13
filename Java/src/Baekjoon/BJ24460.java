package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ24460 {
    static int[][] chair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        chair = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chair[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = findChairNum(0, 0, N);
        System.out.println(result);
    }

    private static int findChairNum(int row, int col, int size) {
        if (size == 1) {
            return chair[row][col];
        }

        int newSize = size / 2;
        ArrayList<Integer> candidate = new ArrayList<>();

        candidate.add(findChairNum(row, col, newSize));
        candidate.add(findChairNum(row + newSize, col, newSize));
        candidate.add(findChairNum(row, col + newSize, newSize));
        candidate.add(findChairNum(row + newSize, col + newSize, newSize));

        Collections.sort(candidate);
        return candidate.get(1);
    }
}
