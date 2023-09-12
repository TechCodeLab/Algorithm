import java.io.*;

/*
 * 투 포인터 이동 원칙
 * sum > N : sum -= start_index; start_index++;
 * sum < N : end_index++; sum += end_index;
 * sum == N : end_index++; sum += end_index; count++;
 
 * start_index++; -> 연속된 자연수에서 왼쪽 값 삭제
 * end_index++; -> 연속된 자연수 범위 한 칸 더 확장
 */

public class P2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 1, sum = 1, start_index = 1, end_index = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum < N) {
                end_index++;
                sum += end_index;
            } else {
                sum -= start_index;
                start_index++;
            }
        }

        System.out.println(count);
        bf.close();
    }
}