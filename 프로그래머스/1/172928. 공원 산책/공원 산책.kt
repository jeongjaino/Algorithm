class Solution {
    lateinit var graph: Array<CharArray>
    val directionMap: HashMap<Char, Pair<Int, Int>> = hashMapOf(
        'N' to Pair(-1, 0), 'S' to Pair(1, 0),
        'W' to Pair(0, -1), 'E' to Pair(0, 1)
    )
    
    fun solution(park: Array<String>, routes: Array<String>): IntArray {  
        var position = Pair(0, 0)
        // graph 할당 
        graph = Array(park.size){ CharArray(park[0].length) { '0' } }
        park.forEachIndexed { row, sectionList -> 
            sectionList.forEachIndexed { col, section ->
                graph[row][col] = section
                
                if(section == 'S') {
                    position = Pair(row, col)
                }
            }
        }
        
        routeLoop@ for(route in routes) {
            val routeList = route.split(" ")
            val distance = routeList[1].toInt()
            val direction = directionMap.get(routeList[0].single()) ?: Pair(0, 0)
            
            var currentPosition = position
            for (time in 1 .. distance) { // 이동할 거리만큼 전진하면서 확인 
                currentPosition = Pair(
                    currentPosition.first + direction.first,
                    currentPosition.second + direction.second,
                )
                
                if (checkPosition(currentPosition).not()) {
                    continue@routeLoop
                }
            }
            
            position = currentPosition  
        }
        
        return intArrayOf(position.first, position.second)
    }
    
    fun checkPosition(position: Pair<Int, Int>): Boolean {    
        // 공원 밖인지 확인 
        val rowSize = graph.size
        val colSize = graph[0].size
        if(position.first !in 0 until rowSize || 
            position.second !in 0 until colSize) {
            return false
        }
        
        // 장애물 확인
        if(graph[position.first][position.second] == 'X') {
            return false
        }
        
        return true
    }
}
