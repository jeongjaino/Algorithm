import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val result : MutableList<Int> = mutableListOf()
        val q : Queue<Int> = LinkedList()
        for(p in progresses){
            q.add(p)
        }
        var count = 1
        var index = 0
        var days = getDays(q.poll(), speeds.first())
        while(q.isNotEmpty()){
            index ++
            val p = q.poll()
            val nextDays = getDays(p, speeds[index])
            if(days >= nextDays){ // 다음이 더 짧을 때, 
                count ++
            }
            else{ // 다음이 더 길 때 
                days = nextDays
                result.add(count) // 지금까지 갯수 넣기
                count = 1
            }
        }
        result.add(count)
        return result.toIntArray()
    }
    fun getDays(p : Int, q : Int): Int{
        return Math.ceil((100 - p).toDouble() / q.toDouble()).toInt()
    }
}