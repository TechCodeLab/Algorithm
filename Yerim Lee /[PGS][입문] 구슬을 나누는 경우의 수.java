
// -----------------------------------------------------------
// my-answer--------------------------------------------------
class Solution {
    public double solution(int balls, int share) {
        double answer = 1.0;
        double divide = 1.0;
        for(int i = share; i > 0; i--){ // i가 1일 때도 곱해줘야 하는데 제대로 지키지 않음
            answer *= balls;
            balls -= 1;
            divide *= i;
        }
        
        answer = answer/divide; // 나머지를 생각하지 못하고 for문 안에 넣었었음

        return answer;
    }
}

// type문제였음
// double과 float(X), Long 차이 잘 생각해보고 정리해놓기!!

// -----------------------------------------------------------
// good-code1-------------------------------------------------
class Solution {
    public long solution(int balls, int share) {
        share = Math.min(balls - share, share);

        if (share == 0)
            return 1;

        long result = solution(balls - 1, share - 1);
        result *= balls;
        result /= share;

        return result;
    }
}

// 더 이해해보기!!

// -----------------------------------------------------------
// good-code2-------------------------------------------------
class Solution {
    public long solution(int balls, int share) {
        long answer = 0;

        int d = (balls - share) > share ? share : balls - share;
        if (d == 0) return 1;

        return solution(balls - 1, d - 1) * balls / d;
    }

}

// 보통 long 타입 사용하시는 것 같음 -> 이유 구하기!
// 두 code 다 재귀...를 쓰셨음... -> 재귀 부분 복습&적용 해보기!!

