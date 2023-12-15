class Solution {
    fun solution(arr: IntArray): Double {
        var sum = 0
        arr.forEach { value -> 
            sum += value
        }
        
        return sum.toDouble() / arr.size.toDouble()
    }
}