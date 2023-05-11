class Solution {
    fun solution(new_id: String): String {
        var answer = new_id.toLowerCase()
        var new = ""
        for(i in answer){
            if(i.isDigit() || i.isLetter() || i == '_' || i == '-' || i == '.'){
                new += i
            }
        }
        answer = new

        answer = removeDuplicate(answer)

        answer = removeDot(answer)
        if(answer.isEmpty()){
            answer = "a"
        }
        
        if(answer.length >= 16){
            answer = answer.slice(0 until 15)
            answer = removeDot(answer)
        }
        
        while(answer.length < 3){
           answer += answer.last()
        }
        
        return answer
    }
    
    fun removeDuplicate(s: String): String{
        var answer = ""
        for(i in 0 until s.length - 1){
            if(s[i] == '.'){
                if(s[i + 1] == '.'){
                    continue
                }
            }
            answer += s[i]
        }
        return answer + s.lastOrNull()
    }

    
    fun removeDot(s: String): String{
        var answer = s
        if(answer.lastOrNull() == '.'){
            answer = answer.slice(0 until answer.lastIndex)
        }
        if(answer.firstOrNull() == '.'){
            answer = answer.slice(1 .. answer.lastIndex)
        }
        return answer
    }
}