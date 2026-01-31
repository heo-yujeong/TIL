package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1991 {
    static int[] left = new int[26];
    static int[] right = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            int parent = a - 'A';
            left[parent] = (b == '.') ? -1 : b - 'A';
            right[parent] = (c == '.') ? -1 : c - 'A';
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    private static void preorder(int now) {
        if (now == -1) return;
        System.out.print((char) (now + 'A'));
        preorder(left[now]);
        preorder(right[now]);
    }

    private static void inorder(int now) {
        if (now == -1) return;
        inorder(left[now]);
        System.out.print((char) (now + 'A'));
        inorder(right[now]);
    }

    private static void postorder(int now) {
        if (now == -1) return;
        postorder(left[now]);
        postorder(right[now]);
        System.out.print((char) (now + 'A'));
    }
}
