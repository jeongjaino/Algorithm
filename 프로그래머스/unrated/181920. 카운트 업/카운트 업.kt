class Solution {
    fun solution(start: Int, end: Int): IntArray {
        var answer = IntArray(end - start + 1)
        for(i in start .. end){
            answer[i - start] = i
        }
        return answer
    }
}