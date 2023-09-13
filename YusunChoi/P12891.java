import java.util.*;
import java.io.*;

/*
 * 문제 해석
 * 입력: 
 * 조건
    - 임의의 문자열에서 부분 문자열 추출 (순서 변경 X)
    - 부분 문자열 안의 문자 개수가 특정 개수 이상
 */

// 35576 KB, 336 ms
public class P12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());
        String dna = bf.readLine();
        st1 = new StringTokenizer(bf.readLine());
        int[] min = new int[4];
        int[] cur = { 0, 0, 0, 0 };

        int[] A = new int[S];
        int[] C = new int[S];
        int[] G = new int[S];
        int[] T = new int[S];

        for (int i = 0; i < S; i++) {
            char e = dna.charAt(i);

            if (i != 0) {
                A[i] = A[i - 1] + A[i];
                C[i] = C[i - 1] + C[i];
                G[i] = G[i - 1] + G[i];
                T[i] = T[i - 1] + T[i];
            }

            switch (e) {
                case 'A':
                    A[i]++;
                    break;
                case 'C':
                    C[i]++;
                    break;
                case 'G':
                    G[i]++;
                    break;
                case 'T':
                    T[i]++;
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st1.nextToken());
        }

        int i = 0, count = 0;

        while (i != dna.length() - P + 1) {
            int end = i + P - 1;

            if (i == 0) {
                cur[0] = A[end];
                cur[1] = C[end];
                cur[2] = G[end];
                cur[3] = T[end];
            } else {
                cur[0] = A[end] - A[i - 1];
                cur[1] = C[end] - C[i - 1];
                cur[2] = G[end] - G[i - 1];
                cur[3] = T[end] - T[i - 1];
            }

            if (cur[0] >= min[0] && cur[1] >= min[1] && cur[2] >= min[2] && cur[3] >= min[3])
                count++;

            i++;
        }

        System.out.println(count);
        bf.close();
    }
}
