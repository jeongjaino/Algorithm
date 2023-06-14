import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val trucks : Queue<Int> = LinkedList<Int>()
        truck_weights.forEach{
            trucks.offer(it)
        }
        val queue : Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        var count = 0
        var sum = 0
        while(trucks.isNotEmpty()){
            count += 1
            if(queue.isNotEmpty()){
                if(count - queue.peek().second >= bridge_length){
                    sum -= ((queue.poll()).first)
                }
            }
            if(sum + trucks.peek() <= weight){
                val truck = trucks.poll()
                queue.offer(Pair(truck, count))
                sum += truck
            }
        }
        return count + bridge_length
    }
}