package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ18222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        System.out.println(thueMorse(k-1));
        br.close();
    }

    public static long thueMorse(long num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        else if (num % 2 == 0)
            return thueMorse(num / 2);
        else
            return 1 - thueMorse(num / 2);
    }
}
