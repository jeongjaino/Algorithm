class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        val len = str1.length
        for(i in 0 until len){
            answer += str1[i]
            answer += str2[i]
        }
        return answer
    }
}