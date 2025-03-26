package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ25601 {
    static HashMap<String, ArrayList<String>> relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        relation = new HashMap<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (!relation.containsKey(A)) {
                relation.put(A, new ArrayList<>());
            }
            relation.get(A).add(B);
        }

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        System.out.println(availableCasting(A, B) || availableCasting(B, A) ? 1 : 0);
    }

    private static boolean availableCasting(String A, String B) {
        if (A.equals(B)) {
            return true;
        }

        if (relation.get(A) == null) {
            return false;
        }

        for (String s : relation.get(A)) {
            if (availableCasting(s, B)) {
                return true;
            }
        }
        return false;
    }
}
