import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q : Queue<Int> = LinkedList<Int>()
        priorities.forEach{
            q.add(it)
        }
        var des = location
        var index = 0
        while(q.isNotEmpty()){
            val v = q.poll()
            if(index == des){
                if(q.maxOrNull() ?: 0 <= v){
                    return priorities.size - q.size
                }
                else{
                    q.add(v)
                    des += q.size
                }
            }
            else {
                if(q.maxOrNull() ?: 0 > v){
                    q.add(v)
                }
            }
            index ++ 
        }
        return 0
    }
}