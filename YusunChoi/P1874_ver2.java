import java.util.*;
import java.io.*;

/*
 * 문제 해석
 * 입력
 - 수열 개수 n
 - 수열 이루는 정수 하나씩 순서대로 (\n로 구분, 중복 없음, 1이상 n이하)
 * 조건
 - stack에 자연수를 오름차순으로 push, pop하며 입력된 수열 만드는 과정 출력
 - push: + / pop: - / 불가: NO
 * 해결
 - 자연수 스택 생성
 - push할 순서의 자연수 변수로 저장
 */

public class P1874_ver2 {
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
        StringBuilder sb = new StringBuilder();
        int l = 1; // 오름차순 수

        for (int i = 0; i < S.length; i++) {
            int su = S[i]; // 현재 수열 수
            if (su >= l) { // 현재 수열 값 >= 오름차순 수: 값 같아질 때까지 push
                while (su >= l) {
                    stack.push(l++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            } else {

                /*
                 * * 수열 값 < 오름차순 수
                 * - 수열 값과 같은 자연수는 이미 stack에 push됨. (pop 여부는 모름)
                 * pop으로 원소 꺼내기
                 */

                int num = stack.pop();

                // 스택의 가장 위의 수 > 수열 수 일 경우 수열 출력 불가
                if (num != su) {

                    /*
                     * 
                     * * 스택의 top > 수열 값
                     * - 수열 값이 나오려면 pop 필수
                     * - 수열은 1부터 n까지의 모든 정수들로 구성되어 있다.
                     * - pop이 필요한 경우는 그 값이 수열 값과 같은 경우일 때밖에 없음.
                     * - 따라서, pop한 값이 수열 값과 다르면 연산 불가능
                     */

                    System.out.println("NO");
                    return;
                } else {
                    sb.append("-\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
