class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        val answer = strings
        answer.sortWith(compareBy<String>{ it[n] }.thenBy{ it })
        return answer
    }
}