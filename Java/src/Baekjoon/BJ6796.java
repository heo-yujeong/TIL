package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int A = 0, B = 0;
        char X, Y;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            st = new StringTokenizer(line);
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 7) break;

            switch (cmd) {
                case 1:
                    X = st.nextToken().charAt(0);
                    int n = Integer.parseInt(st.nextToken());

                    if (X == 'A') A = n;
                    else B = n;
                    break;
                case 2:
                    X = st.nextToken().charAt(0);

                    if (X == 'A') sb.append(A).append('\n');
                    else sb.append(B).append('\n');
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    X = st.nextToken().charAt(0);
                    Y = st.nextToken().charAt(0);

                    int x = (X == 'A') ? A : B;
                    int y = (Y == 'A') ? A : B;
                    int result = 0;

                    switch (cmd) {
                        case 3: result = x + y; break;
                        case 4: result = x * y; break;
                        case 5: result = x - y; break;
                        case 6: result = x / y; break;
                    }

                    if (X == 'A') A = result;
                    else B = result;
                    break;
            }
        }

        System.out.println(sb);
    }
}
