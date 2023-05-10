class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        score.sortDescending()
        var i = 0
        var result = 0
        while(i + m - 1 < score.size){ // i번째 부터 m - 1번째까지 박스에 들어갈 수 있는지 
            result += score[i + m - 1] * m
            i += m 
        }
        return result
    }
}