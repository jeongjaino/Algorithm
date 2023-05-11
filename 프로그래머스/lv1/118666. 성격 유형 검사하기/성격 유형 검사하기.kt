class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val score = intArrayOf(3, 2, 1, 0, 1, 2, 3)
        val board = mutableMapOf(('R' to 0), ('T' to 0), ('C' to 0),
            ('F' to 0), ('J' to 0), ('M' to 0),
            ('A' to 0), ('N' to 0))
        for(i in survey.indices){
            if(choices[i] < 4){
                val type = survey[i].first()
                val value = score[choices[i] - 1] + board[type]!!
                board[type] = value
            }
            else if(choices[i] > 4){
                val type = survey[i].last()
                val value = score[choices[i] - 1] + board[type]!!
                board[type] = value
            }
        }
        val keys = board.keys.toList()
        for(i in 0 until keys.size - 1 step 2){
            if(board[keys[i]]!! >= board[keys[i + 1]]!!){
                answer += keys[i]
            }else{
                answer += keys[i + 1]
            }
        }
        return answer
    }
}