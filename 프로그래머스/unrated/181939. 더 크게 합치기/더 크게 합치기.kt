class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer = a.toString()
        var answer2 = b.toString() 
        answer += b.toString()
        answer2 += a.toString()
        return maxOf(answer.toInt(), answer2.toInt())
    }
}