package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] part = input.split(":", -1);
        ArrayList<String> IPv6 = new ArrayList<>();
        ArrayList<Integer> zeroIdx = new ArrayList<>();

        for (int i = 0; i < part.length; i++) {
            if (part[i].length() == 0) {
                zeroIdx.add(i);
                IPv6.add("");
            } else if (part[i].length() < 4) {
                IPv6.add("0".repeat(4 - part[i].length()) + part[i]);
            } else {
                IPv6.add(part[i]);
            }
        }

        if (!zeroIdx.isEmpty()) {
            int first = zeroIdx.get(0);
            while (IPv6.contains("")) {
                IPv6.remove("");
            }

            while (IPv6.size() < 8) {
                IPv6.add(first, "0000");
            }
        }

        System.out.println(String.join(":", IPv6));
    }
}
