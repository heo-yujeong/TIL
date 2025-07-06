package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ABC = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        int[] nums = new int[10];
        while (ABC != 0) {
            nums[ABC % 10]++;
            ABC /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }
    }
}
