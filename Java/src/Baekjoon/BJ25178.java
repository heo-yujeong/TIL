package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();

        if (A.charAt(0) != B.charAt(0) || A.charAt(N-1) != B.charAt(N-1)) {
            System.out.println("NO");
            return;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < N; i++) {
            cnt[A.charAt(i) - 'a']++;
            cnt[B.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                System.out.println("NO");
                return;
            }
        }

        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            if (!(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')) {
                sbA.append(a);
            }
            if (!(b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u')) {
                sbB.append(b);
            }
        }

        if (sbA.toString().contentEquals(sbB)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
