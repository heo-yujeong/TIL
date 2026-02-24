package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.println("Case #" + t + ": INSOMNIA");
                continue;
            }

            boolean[] digit = new boolean[10];
            int tmp = 0;

            for (int i = 1; ; i++) {
                tmp = N * i;
                String num = String.valueOf(tmp);
                for (int n = 0; n < num.length(); n++) {
                    digit[num.charAt(n) - '0'] = true;
                }

                boolean flag = false;
                for (int n = 0; n < 10; n++) {
                    if (!digit[n]) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("Case #" + t + ": " + tmp);
                    break;
                }
            }
        }
    }
}
