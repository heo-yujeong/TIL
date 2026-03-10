package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("order")) {
                int n = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                list.add(new int[]{n, t});
            } else if (cmd.equals("sort")) {
                list.sort((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                });
            } else if (cmd.equals("complete")) {
                int n = Integer.parseInt(st.nextToken());

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j)[0] == n) {
                        list.remove(j);
                        break;
                    }
                }
            }

            if (list.isEmpty()) {
                sb.append("sleep").append('\n');
            } else {
                for (int[] l : list) {
                    sb.append(l[0]).append(" ");
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
