package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ31562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            String input = br.readLine();
            String[] part = input.split(" ");

            String title = part[1];
            String start = part[2] + part[3] + part[4];

            map.put(start, map.containsKey(start) ? "?" : title);
        }

        while (M-- > 0) {
            String input = br.readLine().replace(" ", "");

            System.out.println(map.getOrDefault(input, "!"));
        }
    }
}
