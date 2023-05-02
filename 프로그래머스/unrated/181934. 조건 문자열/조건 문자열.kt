class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        if(ineq == ">" && eq == "!"){
            if(n > m){
                return 1
            }
        }
        
        else if(ineq == "<" && eq == "!"){
            if(n < m){
                return 1
            }
        }
        
        else if(ineq == ">" && eq == "="){
            if(n >= m){
                return 1
            }
        }
        
        else {
             if(n <= m){
                return 1
            }
        }
        return 0
    }
}