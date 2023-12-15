class Solution {
    fun solution(food: IntArray): String {
        var answer = ""
        food.forEachIndexed { index, number -> 
            if (number >= 2) {
                answer += repeatValue(value = index, time = number / 2)
            }
        }
        val reverseAnswer = answer.reversed() 
        return answer + "0" + reverseAnswer
    }
    
    fun repeatValue(value: Int, time: Int): String {
        var answer = ""
        repeat (time) {
            answer += value.toString()
        }
        return answer 
    }
}