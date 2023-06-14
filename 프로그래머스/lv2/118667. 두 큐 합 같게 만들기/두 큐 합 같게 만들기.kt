import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        // 모든 경우 탐색, 한쪽만 고려해도 됨. 총합의 절반을 큐의 sum
        // 재귀로, 빼는 경우, 더하는 경우 모두 고려,
        // 탈출 조건 : sum == 절반  정답 return / 한쪽이 0 이거나 모든 가지를 다 가지는 경우 -> 
        var halfSum : Long = 0 // 전체 원소의 합의 절반
        var lsum : Long = 0 // q1의 합
        val q1 : Queue<Int> = LinkedList<Int>()
        val q2 : Queue<Int> = LinkedList<Int>()
        queue1.forEach{
            q1.offer(it)
            lsum += it
        }
        queue2.forEach{
            q2.offer(it)
            halfSum += it
        }
        halfSum += lsum
        halfSum /= 2
        
        val limit = queue1.size * 4
        var count = 0 
        while(q1.isNotEmpty() && q2.isNotEmpty()){
            if(lsum < halfSum){
                val e = q2.poll()
                q1.offer(e)
                lsum += e
            }
            else if(lsum > halfSum){
                val e = q1.poll()
                q2.offer(e)
                lsum -= e
            }
            else{ // 큐의 합이 같은 경우
                return count 
            }
            if(count > limit){
                return - 1
            }
            count += 1
        }
        return -1
    }
}