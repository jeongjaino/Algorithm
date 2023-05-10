class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var result = 0
        var left = n
        while(left >= a){
            val m = max(a, left) // 최대로 가져갈 수 있는 수 
            val g = (m / a * b) // 받는 갯수 
            left = left - m + g
            result += g // 받는 갯수는 temp / 3
        }
        return result 
    }
    
    fun max(a : Int, n : Int): Int{
        for(i in n downTo a){
            if(i % a == 0){
                return i
            }
        }
        return 0  
    }
}