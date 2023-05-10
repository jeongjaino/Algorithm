class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        for(i in 1 until food.size){
            answer += (i.toString()).repeat(food[i] / 2)
        }
        return answer + "0" + answer.reversed()
    }
}