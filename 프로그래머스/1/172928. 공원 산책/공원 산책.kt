// S 시작, O 가능, X 장애물 
// routes -> op / n 
// N, S, W, E -> Pair[-1, 0], [1, 0], [0, -1], [0, 1]
// 장애물이 있거나, 공원 밖을 넘는지 확인하고 움직이는 함수 
    // op 조건문
        // 한칸식 움직이면서 비교 
        // false시 break 
    // 반복문 통과 시 현재 위치 저장 
// 현재 위치 저장하는 변수 
// 현재 위치가 장애물이 있는지, 밖인지 확인하는 함수 Pair(Int, Int) -> Boolean

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
        
        for(route in routes) {
            val routeList = route.split(" ")
            val distance = routeList[1].toInt()
            
            val direction = directionMap.get(routeList[0].single()) ?: Pair(0, 0)
            
            var currentPosition = position
            var successFlag = true
            for (time in 1 .. distance) { // 이동할 거리만큼 전진하면서 확인 
                currentPosition = Pair(
                    currentPosition.first + direction.first,
                    currentPosition.second + direction.second,
                )
                
                if (checkPosition(currentPosition).not()) {
                    successFlag = false
                    break 
                }
            }
            
            if(successFlag) {
                position = currentPosition   
            }
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
