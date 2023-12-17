class Solution {
    fun solution(s: String): String {
        val sList = s.split(" ").map{ it.toInt() }
        
        return "${sList.minOrNull()!!} ${sList.maxOrNull()!!}"
    }
}