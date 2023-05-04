class Solution {
    fun solution(num_list: IntArray): Int {
        if(num_list.size < 11){
            var result = 1
            num_list.forEach{
                result *= it
            }
            return result 
        }else{
            return num_list.sum()
        }
    }
}