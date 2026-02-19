package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx1 = Integer.parseInt(st.nextToken());
        int sy1 = Integer.parseInt(st.nextToken());
        int sx2 = Integer.parseInt(st.nextToken());
        int sy2 = Integer.parseInt(st.nextToken());

        int minX = Math.min(x1, sx1);
        int minY = Math.min(y1, sy1);
        int maxX = Math.max(x2, sx2);
        int maxY = Math.max(y2, sy2);

        int width = maxX - minX;
        int height = maxY - minY;
        int side = Math.max(width, height);

        System.out.println(side * side);
    }
}
