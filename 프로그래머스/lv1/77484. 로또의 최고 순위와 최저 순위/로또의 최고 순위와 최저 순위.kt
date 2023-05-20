class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        // 일치하는 갯수 + 0의 갯수 = 최대? 
        // 그냥 일치하는 갯수가 최소 
        var count = 0
        for(i in win_nums){
            if(lottos.contains(i)){
                count += 1
            }
        }
        val zeroCount = lottos.count{ it == 0 }
        var maxResult = 6
        if(count + zeroCount > 1){
            maxResult -= (count + zeroCount - 1)
        }
        return intArrayOf(maxResult, if(count > 1) 6 - (count - 1) else 6)
    }
}