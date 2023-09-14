import java.io.*;
import java.util.*;

/*
 * 문제 해석
 * 입력: N \n M \n 자연수 N개
 - i + j = M
 - 자연수 N 개 중 2가지 조합하여 M을 만들 수 있는 개수
 */

public class P1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String line = bf.readLine();
        int[] arr = new int[N];

        String[] strArr = line.split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        /*
         * 공백을 사이에 둔 자연수 추출 이렇게도 가능
         * StringTokenizer st = new StringTokenizer(bf.readLine());
         * 
         * for (int i = 0; i < N; i++) {
         * arr[i] = Integer.parseInt(st.nextToken());
         * }
         */

        Arrays.sort(arr);

        int count = 0, i = 0, j = N - 1;

        while (i < j) {
            if (arr[i] + arr[j] == M) {
                count++;
                i++;
                j--;
            } else if (arr[i] + arr[j] < M) {
                i++;
            } else if (arr[i] + arr[j] > M) {
                j--;
            }
        }

        /*
         * <오답>
         * - 첫 번째 순서에서 sum = 0으로 초기화 되어있기 때문에, 바로 sum < M으로 분기하게 됨.
         * -> arr[0]+arr[N] 검사 불가
         * 
         * int sum = 0;
         * 
         * while (i < j) {
         * if (sum == M) {
         * count++;
         * i++;
         * j--;
         * sum = arr[i] + arr[j];
         * } else if (sum < M) {
         * i++;
         * sum = arr[i] + arr[j];
         * } else if (sum > M) {
         * j--;
         * sum = arr[i] + arr[j];
         * }
         * }
         */

        System.out.println(count);
        bf.close();
    }
}
