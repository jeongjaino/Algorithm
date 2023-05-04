class Solution {
    fun solution(n: Int, k: Int): IntArray {
        val result = IntArray(n / k)
        for(i in 1 .. n){
            val temp = i * k 
            if(temp > n){
                break
            }
            result[i - 1] = temp
        }
        return result
    }
}