package Baekjoon;

public class BJ4673 {
    public static void main(String[] args) {
        boolean[] chk = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = i;
            int sum = n;

            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum <= 10000) {
                chk[sum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if (!chk[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
