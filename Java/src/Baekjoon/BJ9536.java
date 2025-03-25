package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String pullRecorded = br.readLine();
            Set<String> set = new HashSet<>();
            String animal;

            while (!(animal = br.readLine()).equals("what does the fox say?")) {
                String[] strArr = animal.split(" goes ");
                set.add(strArr[1]);
            }

            String[] fullRecordedArr = pullRecorded.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fullRecordedArr.length; i++) {
                if (!set.contains(fullRecordedArr[i])) {
                    sb.append(fullRecordedArr[i] + " ");
                }
            }

            System.out.println(sb);
        }
    }
}
