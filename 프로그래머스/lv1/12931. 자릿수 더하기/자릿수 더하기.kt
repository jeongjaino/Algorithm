class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        for(i in n.toString()){
            answer += i.digitToInt()
        }
        return answer
    }
}