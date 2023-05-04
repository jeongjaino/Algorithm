class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        for(it in numbers){
            if(answer > n){
                break 
            }
            answer += it
        }
        return answer
    }
}