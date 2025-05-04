package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringNum = Integer.toBinaryString(Integer.parseInt(br.readLine())+1).replace('0', '4').replace('1', '7');

        for (int i = 1; i < stringNum.length(); i++) {
            System.out.print(stringNum.charAt(i));
        }
    }
}
