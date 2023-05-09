class Solution {
    fun solution(t: String, p: String): Int {
        var result: Int = 0
        for(i in 0 .. t.length - p.length){
            if(t.slice(i until i + p.length).toLong() <= p.toLong()){
                result += 1
            }
        }
        return result
    }
}