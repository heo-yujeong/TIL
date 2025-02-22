package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ25957 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Map<String, String>> wordMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            String firstLast = ""+S.charAt(0)+S.charAt(S.length()-1);
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            wordMap.putIfAbsent(firstLast, new HashMap<>());
            wordMap.get(firstLast).put(word, S);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String S = st.nextToken();
            String firstLast = ""+S.charAt(0)+S.charAt(S.length()-1);
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            String result = wordMap.getOrDefault(firstLast, new HashMap<>()).getOrDefault(word, "");
            sb.append(result).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
