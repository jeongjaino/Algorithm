class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer = IntArray(strlist.size)
        for(i in strlist.indices){
            answer[i] = strlist[i].length
        }
        return answer
    }
}