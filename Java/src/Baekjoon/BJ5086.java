package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 == 0 && num2 == 0) {
                break;
            }

            String result = "";
            if (num2 % num1 == 0) {
                result = "factor";
            } else if (num1 % num2 == 0) {
                result = "multiple";
            } else {
                result = "neither";
            }

            System.out.println(result);
        }
    }
}
