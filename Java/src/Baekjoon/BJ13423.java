package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13423 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] X = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(X);

            int cnt = 0;
            for (int i = 0; i < N-2; i++) {
                for (int j = i+1; j < N-1; j++) {
                    for (int k = j+1; k < N; k++) {
                        if (X[j] - X[i] == X[k] - X[j]) {
                            cnt++;
                            break;
                        } else if (X[j] - X[i] < X[k] - X[j]) {
                            break;
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
