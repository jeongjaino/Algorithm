class Solution {
    fun solution(start: Int, end: Int): IntArray {
        val answer = IntArray(start - end + 1)
        var j = 0
        for(i in start downTo end){
            answer[j] = i
            j ++
        }
        return answer
    }
}