package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        int[] result = new int[2];
        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int hap = solution[left] + solution[right];

            if (Math.abs(hap) < min) {
                min = Math.abs(hap);
                result[0] = solution[left];
                result[1] = solution[right];

                if (hap == 0)
                    break;
            }

            if (hap < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
        br.close();
    }
}
