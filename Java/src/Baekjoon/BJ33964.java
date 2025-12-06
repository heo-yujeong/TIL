package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ33964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < X; i++) {
            sb1.append('1');
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < Y; i++) {
            sb2.append('1');
        }

        BigInteger x = new BigInteger(sb1.toString());
        BigInteger y = new BigInteger(sb2.toString());

        System.out.println(x.add(y));
    }
}
