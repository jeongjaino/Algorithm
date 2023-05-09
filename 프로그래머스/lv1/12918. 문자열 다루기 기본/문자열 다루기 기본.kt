class Solution {
    fun solution(s: String): Boolean {
        return if(s.length in intArrayOf(4, 6) && s.all{ it.isDigit() }) true else false
    }
}