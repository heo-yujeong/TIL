package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ34691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            } else if (input.equals("animal")) {
                sb.append("Panthera tigris").append("\n");
            } else if (input.equals("tree")) {
                sb.append("Pinus densiflora").append("\n");
            } else {
                sb.append("Forsythia koreana").append("\n");
            }
        }

        System.out.println(sb);
    }
}
