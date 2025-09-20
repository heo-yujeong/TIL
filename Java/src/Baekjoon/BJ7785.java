package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (Objects.equals(state, "enter")) {
                set.add(name);
            } else if (Objects.equals(state, "leave")) {
                set.remove(name);
            }
        }

        List<String> tmpSet = new ArrayList<>(set);
        tmpSet.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : tmpSet) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
