class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        for(value in 1 .. n) {
            if(n % value == 0) {
                answer += value
            }
        }
        return answer
    }
}