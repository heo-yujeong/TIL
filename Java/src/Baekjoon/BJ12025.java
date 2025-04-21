package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ12025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] wrongPwd = br.readLine().toCharArray();
        int[] num = new int[wrongPwd.length];

        int cnt = 0;
        for (int i = wrongPwd.length - 1; i >= 0; i--) {
            if (wrongPwd[i] == '1' || wrongPwd[i] == '2' || wrongPwd[i] == '6' || wrongPwd[i] == '7') {
                num[cnt++] = i;
                if (wrongPwd[i] == '6') wrongPwd[i] = '1';
                else if (wrongPwd[i] == '7') wrongPwd[i] = '2';
            }
        }

        long k = Long.parseLong(br.readLine());
        k--;
        long maxPwd = (long) Math.pow(2, cnt);

        if (maxPwd < k) {
            System.out.println(-1);
            return;
        }

        cnt = 0;
        while (k > 0) {
            if (k % 2 == 1) {
                if (wrongPwd[num[cnt]] == '1') wrongPwd[num[cnt]] = '6';
                else if (wrongPwd[num[cnt]] == '2') wrongPwd[num[cnt]] = '7';
            }

            k /= 2;
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : wrongPwd) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
