/**
    x만큼 간격이 있는 n 개의 숫자 
    08/17/22

    Long - int 변환이 중요한 문제 
 */
class Solution {
    public long[] solution(int x, int n) {
        
        long[] answer = new long[n];

        
        for (int i = 1; i <= n; i++) {
            
            answer[i-1] = Long.valueOf(x) * i;
        }
        /**
            테스트 케이스 13, 14 실패로 뜨는 이유는 
            int 자료형으로 되어 있을 경우이다. 
            long 형태를 유지시켜 주어야함.
            ex)  
            int x=4;
            Long xLong=Long.valueOf(x);

            Long x = 11L;
            int xInt = x.intValue();
            int xInt = Long.valueOf(x).intValue();
         */
        
        return answer;
    }
}
