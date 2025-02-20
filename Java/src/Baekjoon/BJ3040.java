package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        int hap = 0;
        for (int i = 0; i < 9; i++) {
            hap += dwarf[i];
        }

        int goal = hap - 100;
        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == goal) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            }
            System.out.println(dwarf[i]);
        }
        br.close();
    }
}
