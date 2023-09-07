import java.util.*;

/*
 [문제 정리]
 1. 입력 - N(숫자 개수), N개의 숫자(*공백 없음)
 2. 출력: N개의 숫자들의 합
 */

public class P11720 {
    public static void main(String[] args) {
        int N, result = 0;
        String line;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        line = sc.nextLine();

        for (int i = 0; i < N; i++) {
            result += Integer.parseInt(line.substring(i, i + 1));
        }

        System.out.println(result);

        sc.close();
    }
}
