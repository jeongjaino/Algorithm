class Solution {
    fun solution(a: Int, b: Int): String {
        // 1월 1일 부터 a월 b일 까지 일을 구해서 나머지연산으로 
        var days = 0
        for(i in 1 until a){
            if(i in intArrayOf(4, 6, 9, 11)){
                days += 30
            }
            else if(i == 2){
                days += 29
            }
            else{
                days += 31
            }
        }
        days += b - 1  // 1월 1일
        
        return when(days % 7){
            0 -> { "FRI" }
            1 -> { "SAT" }
            2 -> { "SUN" }
            3 -> { "MON" }
            4 -> { "TUE" }
            5 -> { "WED" }
            6 -> { "THU" }
            else -> { "" }
        }
    }
}