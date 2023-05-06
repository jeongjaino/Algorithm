import kotlin.math.*

class Solution {
    fun solution(s: String): Int {
        if(s.first().toString() == "-"){
            return s.substring(1, s.length).toInt() * -1
        }else{
            return s.toInt()
        }
    }
}