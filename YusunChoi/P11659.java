import java.util.*;

public class P11659 {

    public static void main(String[] args) {
        int N, M, i, j;
        long a;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        long[] S = new long[N + 1];

        for (int l = 1; l <= N; l++) {
            a = sc.nextLong();

            if (l == 1) {
                S[l] = a;
            } else {
                S[l] = S[l - 1] + a;
            }
        }

        for (int l = 0; l < M; l++) {
            i = sc.nextInt();
            j = sc.nextInt();

            System.out.println(S[j] - S[i - 1]);
        }

        sc.close();
    }
}