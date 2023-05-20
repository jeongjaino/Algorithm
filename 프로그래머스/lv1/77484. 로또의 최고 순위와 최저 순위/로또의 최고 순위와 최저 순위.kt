class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var count = 0
        for(i in win_nums){
            if(lottos.contains(i)){
                count += 1
            }
        }
        val zeroCount = lottos.count{ it == 0 }
        return intArrayOf(rank(count + zeroCount), rank(count))
    }
    fun rank(count : Int): Int = if(count > 1) (7 - count) else 6
}