package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'a']++;
        }

        int max = -1;
        char chr = '?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                chr = (char) (i + 65);
            } else if (arr[i] == max) {
                chr = '?';
            }
        }

        System.out.println(chr);
    }
}
