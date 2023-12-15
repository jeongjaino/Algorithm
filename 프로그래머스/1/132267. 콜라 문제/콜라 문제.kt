// n % a + (n / a) * b 
// n > a 반복 

class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var have = n 
        
        while (have >= a) {
            val left = have % a
            val given = have / a * b 
            
            answer += given 
            have = left + given 
        }
        return answer
    }
}