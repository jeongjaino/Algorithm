class Solution {
    fun solution(num_list: IntArray): IntArray {
        val answer = IntArray(2)
        num_list.forEach{
            if(it % 2 == 0){
                answer[0] += 1
            }else{
                answer[1] += 1
            }
        }
        return answer
    }
}