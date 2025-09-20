package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> mapInt = new HashMap<>();
        HashMap<String, Integer> mapString = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            mapInt.put(i, name);
            mapString.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (Character.isDigit(name.charAt(0))) {
                sb.append(mapInt.get(Integer.parseInt(name))).append("\n");
            } else {
                sb.append(mapString.get(name)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
