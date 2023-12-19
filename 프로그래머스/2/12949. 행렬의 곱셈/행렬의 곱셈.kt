class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size){ 0 } }
        
        for(row in arr1.indices) {
            for (col in arr2[0].indices) {
                for(commonIndex in arr1[0].indices) {
                    answer[row][col] += 
                        (arr1[row][commonIndex] * arr2[commonIndex][col])
                }
            }
        }
        
        return answer
    }
}