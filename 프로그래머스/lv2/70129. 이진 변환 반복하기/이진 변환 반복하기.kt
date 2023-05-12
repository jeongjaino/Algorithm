class Solution {
    fun solution(s: String): IntArray {
        var count = 0
        var removeCount = 0
        var ns = s
        while(ns != "1"){
            removeCount += ns.count{ it == '0' }
            ns = Integer.toBinaryString(ns.replace("0", "").length)
            count ++
            if(count > 100){
                break
            }
        }
        return intArrayOf(count, removeCount)
    }
}