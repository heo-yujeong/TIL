package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] students = new String[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i][0] = st.nextToken();
            students[i][1] = st.nextToken();
            students[i][2] = st.nextToken();
            students[i][3] = st.nextToken();
        }

        Arrays.sort(students, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[3].equals(o2[3])) {
                    if (o1[2].equals(o2[2]))
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
            }
        });

        System.out.println(students[n - 1][0]);
        System.out.println(students[0][0]);
    }
}
