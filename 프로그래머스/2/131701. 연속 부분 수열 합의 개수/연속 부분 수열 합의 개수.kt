class Solution {
    fun solution(elements: IntArray): Int {
        val size = elements.size
        val result: MutableSet<Int> = mutableSetOf()
        
        for(multipleTime in 1 .. size) { // 길이 
            for(index in 0 until size) { // 시작점 
                var sum = 0
                for(time in 0 until multipleTime) { // 길이만큼 반복 
                    val circleIndex = (index + time) % size 
                    sum += elements[circleIndex]
                }
                result.add(sum)
            }
        }
        
        return result.size
    }
}