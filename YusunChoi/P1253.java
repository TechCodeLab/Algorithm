import java.util.*;
import java.io.*;

/*
 * 문제 해석
 * 입력: 수의 개수 N \n N의 정수들 (공백으로 구분)
 * 조건
 - arr[i] == arr[j] + arr[l] (어떤 수가 다른 수 두 개의 합)
 - 배열 내 위치 다르면 값 같아도 다른 수
 * 해결
 - 입력 받은 수의 배열 정렬
 - 투 포인터로 탐색
 */

public class P1253 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // **정렬 (투 포인터 적용을 위해서는 정렬된 상태의 배열이 필요하다.)
        Arrays.sort(arr);

        int count = 0, i = 0, j = 0, l = N - 1;

        while (i < N) {
            if (j >= l) {
                j = 0;
                l = N - 1;
                i++;
                continue;
            }

            if (j == i) {
                j++;
                continue;
            } else if (l == i) {
                l--;
                continue;
            }

            if (arr[j] + arr[l] == arr[i]) {
                count++;
                j = 0;
                l = N - 1;
                i++;
            } else if (arr[j] + arr[l] < arr[i]) {
                j++;
            } else if (arr[j] + arr[l] > arr[i]) {
                l--;
            }
        }

        System.out.println(count);
        bf.close();
    }
}
