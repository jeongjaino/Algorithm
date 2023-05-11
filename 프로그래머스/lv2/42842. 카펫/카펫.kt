class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        // 총 타일의 갯수로 모든 배열 구성하기 col < row 
        // 테두리의 경우 상하좌우 중 하나가 벗어난 경우 
        // 카운트하는 함수. 
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