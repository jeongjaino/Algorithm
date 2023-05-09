class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        val list : Array<Pair<Char, String>> = Array(strings.size){ Pair('a', "") }
        for(i in strings.indices){
            list[i] = Pair(strings[i][n], strings[i]) 
        }
        list.sortWith(compareBy<Pair<Char, String>>{ it.first }.thenBy { it.second })
        val answer = Array<String>(strings.size){""}
        for(i in list.indices){
            answer[i] = list[i].second
        }
        return answer
    }
}