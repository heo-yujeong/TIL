package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Ca = Integer.parseInt(st.nextToken());
        int Ba = Integer.parseInt(st.nextToken());
        int Pa = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Cr = Integer.parseInt(st.nextToken());
        int Br = Integer.parseInt(st.nextToken());
        int Pr = Integer.parseInt(st.nextToken());

        int cnt = 0;
        cnt += (Ca >= Cr ? 0 : Cr-Ca);
        cnt += (Ba >= Br ? 0 : Br-Ba);
        cnt += (Pa >= Pr ? 0 : Pr-Pa);

        System.out.println(cnt);
    }
}
