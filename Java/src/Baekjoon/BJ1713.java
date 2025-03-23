package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalCnt = Integer.parseInt(br.readLine());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalCnt; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (map.containsKey(student)) {
                map.put(student, map.get(student) + 1);
            } else {
                if (map.size() == N) {
                    int minStudent = map.entrySet().stream()
                            .min(Map.Entry.comparingByValue())
                            .get().getKey();
                    map.remove(minStudent);
                }
                map.put(student, 1);
            }
        }

        map.keySet().stream().sorted().forEach(student -> System.out.print(student + " "));
        br.close();
    }
}
