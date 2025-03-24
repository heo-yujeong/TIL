package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();
            if (set.contains(studentId)) {
                set.remove(studentId);
            }
            set.add(studentId);
        }

        for (String studentId : set) {
            if (K > 0) {
                System.out.println(studentId);
                K--;
            }
        }
        br.close();
    }
}
