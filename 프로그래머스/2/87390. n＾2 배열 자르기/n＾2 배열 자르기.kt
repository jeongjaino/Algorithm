class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var result: MutableList<Int> = mutableListOf()
        
        for(index in left .. right) {
            val x = index / n + 1
            val y = index % n + 1
            result.add(maxOf(x, y).toInt())
        }
        
        return result.toIntArray()
    }
}