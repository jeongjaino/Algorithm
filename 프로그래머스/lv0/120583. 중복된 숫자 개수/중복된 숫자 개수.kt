class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var count = 0
        array.forEach{
            if(it == n){
                count += 1
            }
        }
        return count
    }
}