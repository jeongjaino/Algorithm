import kotlin.math.pow
class Solution {
    fun solution(n: Int, t: Int): Int = n * (2f.pow(t.toFloat())).toInt()
}