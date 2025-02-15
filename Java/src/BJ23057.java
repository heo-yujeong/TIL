import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ23057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            total += numbers[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            combinations(numbers, set, 0, 0, i);
        }

        System.out.println(total - set.size());
        br.close();
    }

    private static void combinations(int[] numbers, Set<Integer> set, int start, int hap, int len) {
        if (len == 0) {
            set.add(hap);
            return;
        }

        for (int i = start; i < numbers.length; i++)
            combinations(numbers, set, i+1, hap+numbers[i], len-1);
    }
}