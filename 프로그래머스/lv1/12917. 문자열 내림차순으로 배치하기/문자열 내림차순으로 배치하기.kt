class Solution {
    fun solution(s: String): String {
        val result = s.toCharArray()
        result.sortDescending()
        return result.joinToString("")
    }
}