class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer : MutableList<Int> = mutableListOf()
        for(i in arr){
            if(i % divisor == 0){
                answer.add(i)
            }
        }
        if(answer.size > 0){
            return answer.sorted().toIntArray()
        }else{
            return intArrayOf(-1)
        }
    }
}