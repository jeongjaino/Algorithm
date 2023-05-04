class Solution {
    fun solution(n: Int): Int {
        val ns = n.toString()
        var result = 0
        for(i in ns.indices){
            result += ns[i].digitToInt()
        }
        return result
    }
}