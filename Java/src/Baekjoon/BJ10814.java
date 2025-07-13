package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[][] member = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            member[i][0] = st.nextToken();
            member[i][1] = st.nextToken();
        }

        Arrays.sort(member, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(member[i][0] + " " + member[i][1]);
        }
    }
}
