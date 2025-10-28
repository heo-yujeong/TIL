package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N / 2]);

        int mode = Collections.max(cnt.values());
        List<Integer> freqList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == mode) {
                freqList.add(entry.getKey());
            }
        }

        Collections.sort(freqList);
        if (freqList.size() >= 2) {
            System.out.println(freqList.get(1));
        } else {
            System.out.println(freqList.get(0));
        }

        System.out.println(arr[N-1] - arr[0]);
    }
}
