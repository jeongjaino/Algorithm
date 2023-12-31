class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var result = 0
        getDungeonOrder(dungeons.size).forEach { order ->
           val number = getExploredDungeonNumber(k, dungeons, order)
           result = maxOf(result, number)
        }
        return result
    }
    
    fun getDungeonOrder(n: Int): List<List<Int>> {
        val numbers = IntArray(n){ it -> it }
        val temp = IntArray(n)
        val visited = BooleanArray(n)
        val list = mutableListOf<List<Int>>()
        
        fun recursionPermutation(depth: Int = 0) {
            if(depth == n) {
                list.add(temp.toList())
                return 
            }
            
            numbers.forEachIndexed { index, value ->
                if(!visited[index]) {
                    visited[index] = true
                    temp[depth] = value
                    recursionPermutation(depth + 1)
                    visited[index] = false
                }
            }
        }
        
        recursionPermutation()
        return list
    }
    
    fun getExploredDungeonNumber(k: Int, dungeons: Array<IntArray>, dungeonOrder: List<Int>): Int {
        var fatigue = k
        var result = 0
        dungeonOrder.forEach { order ->
            if(fatigue >= dungeons[order][0]) {
                fatigue -= dungeons[order][1]
                result += 1
            }
            else {
                return result
            }
        }
        return result 
    }
}