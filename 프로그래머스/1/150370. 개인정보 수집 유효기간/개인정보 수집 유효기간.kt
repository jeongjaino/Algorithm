// 오늘 날짜와 수집날짜의 차이가 terms보다 큰지 작은지 

class Solution {
    fun solution(
        today: String, terms: Array<String>, privacies: Array<String>
    ): IntArray {
        val termMap = HashMap<String, Int>()
        
        terms.forEach { term ->
            val termList = term.split(" ") // 1 type, 2 month
            termMap.put(termList[0], termList[1].toInt())
        }
        
        val answer: MutableList<Int> = mutableListOf()
        
        privacies.forEachIndexed { number, privacie ->
            val privacieList = privacie.split(" ")
            
            val collectDate = privacieList[0]
            // 오늘날짜와 수집날짜 간격
            val distance = getDays(today) - getDays(collectDate) 
            
            val term = termMap.get(privacieList[1]) ?: 0                    
            if (distance > term * 28 - 1) { // 오늘날짜 > 수집날짜 + 계약기간 - 1 (오늘)
                answer.add(number + 1) 
            }
        }
        return answer.toIntArray()
    }
    
    fun getDays(date: String): Int {
        return date.slice(0 .. 3).toInt() * 12 * 28 +
            date.slice(5 .. 6).toInt() * 28 + date.slice(8 .. 9).toInt()
    }
}