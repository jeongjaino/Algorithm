class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer : String = ""
        for(c in s){
            var newc = c.toInt()
            for(i in 1 .. index){
                newc += 1
                if(newc > 122){
                    newc -= 26
                }
                while(newc.toChar() in skip){
                    newc += 1 // 중복으로 되는 경우 
                    if(newc > 122){
                        newc -= 26
                    }
                }
            }
            answer += newc.toChar()
        }
        return answer
    }
}