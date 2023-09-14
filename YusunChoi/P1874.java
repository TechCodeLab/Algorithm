import java.util.*;
import java.io.*;

/*
 * 문제 해석
 * 입력
 - 수열 개수 n \n 수열 이루는 정수 하나씩 순서대로 (\n로 구분, 중복 없음)
 * 조건
 - stack에 자연수를 오름차순으로 push, pop하며 입력된 수열 만드는 과정 출력
 - push: + / pop: - / 불가: NO
 * 해결
 - 자연수 스택 생성
 - push할 순서의 자연수 변수로 저장
 - try-catch 문으로 pop 불가 예외 처리
 */

public class P1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] S = new int[n];

        // 수열 입력
        for (int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(bf.readLine());
        }

        // 스택 연산
        Stack<Integer> stack = new Stack<>();
        int l = 1, i = 0;
        StringBuilder sb = new StringBuilder();

        try {
            while (i < n) {
                if (S[i] >= l) {
                    stack.push(l++);
                    sb.append("+\n");
                } else {
                    int num = stack.pop();
                    sb.append("-\n");

                    if (num == S[i])
                        i++;
                }
            }
        } catch (EmptyStackException e) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb.toString());
    }
}
