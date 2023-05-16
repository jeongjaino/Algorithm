class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val result = IntArray((right - left).toInt() + 1)
        for(i in 0 .. (right - left).toInt()){
            val index = i.toLong() + left 
            result[i] = 1 + maxOf(index / n.toLong(), index % n.toLong()).toInt()
        }
        return result
    }
}