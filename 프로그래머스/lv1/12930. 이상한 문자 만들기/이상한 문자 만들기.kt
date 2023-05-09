class Solution {
    fun solution(s: String): String {
        var odd : Boolean = false
        var answer = ""
        for(i in s){
            if(i.isLetter()){
                if(odd){ // 홀수 
                    answer += i.lowercaseChar()
                    odd = false
                }else{
                    answer += i.uppercaseChar()
                    odd = true
                }
                continue
            } 
            // 공백일 때 
            answer += i
            odd = false // 다시 초기화 
        }
        return answer
    }
}