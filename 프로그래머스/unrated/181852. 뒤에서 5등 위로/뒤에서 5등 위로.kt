class Solution {
    fun solution(num_list: IntArray): IntArray {
        num_list.sort()
        return num_list.sliceArray(5 .. num_list.lastIndex)
    }
}