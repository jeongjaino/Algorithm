class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val tiles = brown + yellow
        var col = 1
        var row = tiles / col
        while(col < row){
            val graph = Array(row){ IntArray(col) }
            var count = 0
            for(i in graph.indices){
                for(j in graph[i].indices){
                    if(i != 0 && i != row - 1 && j != col - 1 && j != 0){
                        count += 1
                    }
                }
            }
            if(count == yellow){
                return intArrayOf(row, col)
            }
            col += 1
            row = tiles / col
        }
        return intArrayOf(row, col)
    }
}