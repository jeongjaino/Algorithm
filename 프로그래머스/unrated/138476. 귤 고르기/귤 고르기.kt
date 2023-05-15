class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map : MutableMap<Int, Int> = mutableMapOf()
        tangerine.forEach{ i ->
            map[i] = (map[i] ?: 0) + 1
        }
        var tl = map.toList().sortedWith(compareBy{ -it.second })
        var total = 0
        var index = 0
        while(total < k){
            total += tl[index].second
            index += 1
        }
        return index
    }
}