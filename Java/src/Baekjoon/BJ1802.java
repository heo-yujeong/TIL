package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            if (foldable(str))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean foldable(String str) {
        if (str.length() > 1) {
            int half = str.length() / 2;

            if (!foldable(str.substring(0, half)))
                return false;
            if (!foldable(str.substring(half+1)))
                return false;

            for (int i = 1; i < half+1; i++) {
                if (str.charAt(half - i) == str.charAt(half + i))
                    return false;
            }
        }

        return true;
    }
}